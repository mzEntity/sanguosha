package org.example.game;

import org.example.game.action.stage.*;
import org.example.game.board.*;
import org.example.game.board.area.player.PlayerArea;
import org.example.game.board.card.Card;
import org.example.game.board.card.Deck;
import org.example.game.board.card.Suit;
import org.example.game.role.Role;
import org.example.game.action.Turn;
import org.example.tools.FileOperator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GameBuilder {
    public Game buildGame(int playerCount){
        Board board = new BoardBuilder().buildBoard(playerCount);
        List<Card> cardList = this.prepareCards();
        List<Role> roles = new ArrayList<>();
        for(int i = 0; i < playerCount; i++){
            Role role = this.buildRole(i, board.area.playerAreas.get(i));
            roles.add(role);
        }
        for(int i = 0; i < playerCount; i++){
            int leftIndex = (i + playerCount - 1) % playerCount;
            int rightIndex = (i + 1) % playerCount;
            Role role = roles.get(i);
            role.left = roles.get(leftIndex);
            role.right = roles.get(rightIndex);
        }
        Game game = Game.getGame();
        assert cardList != null;
        game.cards = new ArrayList<>(cardList);
        game.roles = roles;
        game.board = board;
        Deck.prepareDeck(cardList).moveAllToBack(game.board.area.discardArea.discardedCards);
        List<List<Integer>> distance = new ArrayList<>();
        for(int i = 0; i < playerCount; i++){
            distance.add(new ArrayList<>());
            for(int j = 0; j < playerCount; j++){
                int tmp = Math.abs(i - j);
                distance.get(i).add(Math.min(tmp, playerCount - tmp));
            }
        }
        game.distance = distance;
        return game;
    }

    public Role buildRole(int playerId, PlayerArea playerArea){
        Role role = new Role(playerId);

        Turn turn = new Turn(role);
        turn.turnStartStage = new TurnStartStage(role);
        turn.preparationStage = new PreparationStage(role);
        turn.divinationStage = new DivinationStage(role);
        turn.drawStage = new DrawStage(role);
        turn.punchingStage = new PunchingStage(role);
        turn.discardingStage = new DiscardingStage(role);
        turn.turnFinishStage = new TurnFinishStage(role);

        role.turn = turn;

        role.matchArea(playerArea);
        return role;
    }

    private List<Card> prepareCards(){
        List<String> lines = FileOperator.readFile("./src/main/resources/table.txt");
        int lineNum = lines.size();
        if(lineNum % 2 != 0){
            System.err.println("error in table.txt");
            return null;
        }
        int pairNum = lineNum / 2;
        List<Card> cardList = new ArrayList<>();

        String regexStr = "\\((\\d+),([CDHS])\\)";
        Pattern pattern = Pattern.compile(regexStr);
        for(int i = 0; i < pairNum; i++){
            String cardId = lines.get(i * 2);
            String cardInstanceListStr = lines.get(i * 2 + 1);

            Matcher matcher = pattern.matcher(cardInstanceListStr);

            while(matcher.find()){
                Suit suit = Suit.getSuit(matcher.group(2));
                int point = Integer.parseInt(matcher.group(1));
                Card card = new Card(suit, point, cardId);
                cardList.add(card);
            }
        }

        cardList.sort(new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.point - o2.point;
            }
        });
        return cardList;
    }
}
