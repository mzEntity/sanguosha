package org.example.game.role;

import org.example.game.Game;
import org.example.game.board.area.player.PlayerArea;
import org.example.game.board.card.deck.Deck;
import org.example.game.logic.action.stage.Turn;
import org.example.game.role.hero.Condition;
import org.example.game.role.hero.Hero;

import java.util.ArrayList;
import java.util.List;

public class Role {

    public String code;
    public int id;

    private PlayerArea playerArea;
    private List<Turn> turns;

    public Condition condition;

    private Hero hero;

    public Role(int id) {
        this.id = id;
        this.playerArea = null;
        this.code = id + "";
        this.turns = new ArrayList<>();
        this.hero = null;
    }

    public Turn getCurrentTurn(){
        return this.getTurnByRoundNo(Game.getRoundNo());
    }

    public Turn getTurnByRoundNo(int roundNo){
        if(roundNo >= turns.size()){
            int moreTurnCount = roundNo - turns.size() + 1;
            for(int i = 0; i < moreTurnCount; i++){
                this.turns.add(new Turn(this));
            }
        }
        return turns.get(roundNo);
    }

    public Deck getHandDeck(){
        return this.playerArea.getHandArea().getDeck();
    }

    public void matchArea(PlayerArea playerArea){
        this.playerArea = playerArea;
    }

    public PlayerArea getPlayerArea(){
        return this.playerArea;
    }

    public void setHero(Hero hero){
        this.hero = hero;
        Condition initCondition = hero.getInitCondition();
        this.condition = new Condition(initCondition.hpMax, initCondition.hp);
    }

    public boolean isAlive(){
        return this.condition.isAlive();
    }

    public boolean isFullBlood(){
        return this.condition.hp == this.condition.hpMax;
    }

    public int getHpLost(){
        return this.condition.hpMax - this.condition.hp;
    }

    public void gainHp(int count){
        this.condition.hp += count;
    }

    public void loseHp(int count){
        this.condition.hp -= count;
    }

    public boolean isDying(){
        return this.condition.hp <= 0;
    }

    public void die(){
        this.condition.isAlive = false;
    }



    @Override
    public String toString() {
        return "Role(" + id + ')';
    }
}
