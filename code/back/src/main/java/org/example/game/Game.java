package org.example.game;

import org.example.game.logic.Turn;
import org.example.game.logic.Action;
import org.example.game.board.Board;
import org.example.game.board.card.Card;
import org.example.game.board.card.deck.Deck;
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
        super();
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

    public static List<Role> getRoles(){
        return game.roles;
    }

    public static List<Role> getAliveRoles(){
        List<Role> aliveRoles = new ArrayList<>();
        for(Role role: game.roles){
            if(role.isAlive()){
                aliveRoles.add(role);
            }
        }
        return aliveRoles;
    }


    public boolean noMoreThanOneLeft(){
        int liveCount = 0;
        for(Role r: this.roles){
            if(r.isAlive()){
                liveCount++;
            }
        }
        return liveCount <= 1;
    }

    @Override
    protected void mainLogic(Action from) {
        for(int i = 0; i < 50; i++){
            int liveCount = 0;
            for(Role r: roles){
                if(r.isAlive()){
                    liveCount += 1;
                    new Turn(r).process(this);
                } else {
                    Logger.printf("玩家%s已死亡，跳过回合\n", r.code);
                }
            }
            if(liveCount <= 1){
                Logger.printf("仅剩%s名玩家，游戏结束\n", liveCount);
                break;
            }
        }
    }
}
