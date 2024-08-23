package org.example.game;

import org.example.game.board.*;
import org.example.game.board.card.Card;
import org.example.game.board.card.deck.Deck;
import org.example.game.board.card.CardBuilder;
import org.example.game.role.Role;

import java.util.*;


public class GameBuilder {
    public Game buildGame(int playerCount){
        Board board = new BoardBuilder().buildBoard(playerCount);
        List<Card> cardList = CardBuilder.buildDeck();
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
}
