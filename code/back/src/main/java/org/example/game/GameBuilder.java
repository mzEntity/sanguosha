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
        List<Role> roles = this.prepareRoles(playerCount, board);

        Game game = Game.getGame();
        assert cardList != null;
        game.cards = new ArrayList<>(cardList);
        game.roles = roles;
        game.board = board;
        Deck.prepareDeck(cardList).moveAllToBack(game.board.area.discardArea.discardedCards);

        return game;
    }

    private List<Role> prepareRoles(int playerCount, Board board){
        List<Role> roles = new ArrayList<>();
        for(int i = 0; i < playerCount; i++){
            Role role = new Role(i);
            role.matchArea(board.area.playerAreas.get(i));
            roles.add(role);
        }
        return roles;
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
