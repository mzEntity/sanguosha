package org.example.game;

import org.example.game.board.card.CardDict;
import org.example.game.action.Action;
import org.example.game.board.Board;
import org.example.game.board.card.Card;
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

    public List<List<Integer>> distance;

    public Board board;

    private Game() {
        super("Game", null);
        this.activeRole = null;
        this.distance = new ArrayList<>();
    }

    public static Game getGame(){
        return game;
    }

    public boolean start(){
        for(Card c: this.cards){
            Logger.printf("%s\n", c);
        }

        for(Role role: this.roles){
            role.setHero(new Hero(3, "Default Hero"));
        }

        new LogicConfig(this.roles).initLogic();

        this.process(null);
        return true;
    }

    @Override
    protected void mainLogic(Action from) {
        for(int i = 0; i < 50; i++){
            for(Role r: roles){
                if(r.getHero().condition.alive){
                    r.turn.process(this);
                }
            }
        }
    }

    public int getAliveRoleCount(){
        int count = 0;
        for(Role r: this.roles){
            if(r.getHero().condition.alive){
                count++;
            }
        }
        return count;
    }

    public void printDistance(){
        int roleCount = this.roles.size();
        Logger.printf("    ");
        for(int i = 0; i < roleCount; i++){
            Logger.printf("%2d\t", i);
        }
        Logger.printf("\n");
        for(int i = 0; i < roleCount; i++){
            Logger.printf("%2d  ", i);
            for(int j = 0; j < roleCount; j++){
                Logger.printf("%2d\t", this.distance.get(i).get(j));
            }
            Logger.printf("\n");
        }
    }

    public static void main(String[] args) {
        CardDict.initCardDict();

        int roleNum = 5;
        Game game = new GameBuilder().buildGame(roleNum);
        game.start();
    }


}
