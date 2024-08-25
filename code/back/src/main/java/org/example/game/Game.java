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

    public int currentRoundNo;

    private Game() {
        super();
        this.activeRole = null;
        this.currentRoundNo = 0;
    }

    public static Game getGame(){
        return game;
    }

    public boolean start(){
        for(Card c: this.cards){
            Logger.printf("%s\n", c);
        }

        for(Role role: this.roles){
            role.setHero(new Hero(20, 20, "Default Hero"));
        }

        new LogicConfig().initLogic();

        this.process(null);
        return true;
    }

    public static Deck getDiscardDeck(){
        return game.board.area.discardArea.getDeck();
    }

    public static Deck getDrawDeck(){
        return game.board.area.drawArea.getDeck();
    }

    public static List<Role> getRoles(){
        return game.roles;
    }

    public static Role getAliveNext(Role subject){
        if(!subject.isAlive()){
            return null;
        }
        int index = game.roles.indexOf(subject);
        for(int i = 0; i < game.roles.size(); i++){
            Role r = game.roles.get((index + i + 1) % game.roles.size());
            if(r.isAlive()) return r;
        }
        return null;
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
        this.currentRoundNo = 0;
        for(int i = 0; i < 50; i++){
            for(Role r: roles){
                if(r.isAlive()){
                    r.getTurnByRoundNo(this.currentRoundNo).process(this);
                } else {
                    Logger.printf("玩家%s已死亡，跳过回合\n", r.code);
                }
            }
            this.currentRoundNo += 1;
        }
    }

    public static int getRoundNo(){
        return game.currentRoundNo;
    }
}
