package org.example.game;

import org.example.game.action.Turn;
import org.example.game.board.card.CardDict;
import org.example.game.action.Action;
import org.example.game.board.Board;
import org.example.game.board.card.Card;
import org.example.game.board.card.Deck;
import org.example.game.role.Role;
import org.example.game.role.hero.Hero;
import org.example.log.Logger;

import java.util.ArrayList;
import java.util.List;

public class Game extends Action {

    private static Game game = new Game();

    public List<Card> cards;
    public List<Role> roles;
    public Role activeRole;

    public Board board;

    private Game() {
        super(null);
        this.activeRole = null;
    }

    public static Game getGame(){
        return game;
    }

    public boolean start(){
        for(Card c: this.cards){
            Logger.printf("%s\n", c);
        }

        for(Role role: this.roles){
            role.setHero(new Hero(3, 3, "Default Hero"));
        }

        new LogicConfig().initLogic();

        this.process(null);
        return true;
    }

    public static Deck getDiscardDeck(){
        return game.board.area.discardArea.discardedCards;
    }

    public static Deck getDrawDeck(){
        return game.board.area.drawArea.available;
    }

    @Override
    protected void mainLogic(Action from) {
        for(int i = 0; i < 50; i++){
            boolean hasLiving = false;
            for(Role r: roles){
                if(r.isAlive()){
                    hasLiving = true;
                    new Turn(r).process(this);
                }
            }
            if(!hasLiving){
                break;
            }
        }
    }
}
