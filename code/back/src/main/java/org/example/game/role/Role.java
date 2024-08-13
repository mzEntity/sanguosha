package org.example.game.role;

import org.example.game.board.area.player.PlayerArea;
import org.example.game.action.Turn;
import org.example.game.board.card.Deck;
import org.example.game.role.hero.Condition;
import org.example.game.role.hero.Hero;

public class Role {

    public String code;
    public int id;
    public PlayerArea playerArea;

    public Condition condition;

    private Hero hero;

    public Role(int id) {
        this.id = id;
        this.playerArea = null;
        this.code = id + "";
        this.hero = null;
    }

    public Deck getHandDeck(){
        return this.playerArea.handArea.cards;
    }

    public void matchArea(PlayerArea playerArea){
        this.playerArea = playerArea;
    }

    public void setHero(Hero hero){
        this.hero = hero;
        Condition initCondition = hero.getInitCondition();
        this.condition = new Condition(initCondition.hpMax, initCondition.hp);
    }

    public boolean isAlive(){
        return this.condition.isAlive();
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
        return "Role{" +
                "id=" + id +
                '}';
    }
}
