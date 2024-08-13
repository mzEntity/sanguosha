package org.example.game.role;

import org.example.game.board.area.player.PlayerArea;
import org.example.game.action.Turn;
import org.example.game.role.hero.Hero;

public class Role {

    public String code;
    public int id;
    public Turn turn;
    public PlayerArea playerArea;

    public Role left;
    public Role right;

    public int attackRange;

    private Hero hero;

    public Role(int id) {
        this.id = id;
        this.playerArea = null;
        this.code = id + "";
        this.attackRange = 1;
        this.hero = null;
    }

    public void matchArea(PlayerArea playerArea){
        this.playerArea = playerArea;
    }

    public void setHero(Hero hero){
        this.hero = hero;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                '}';
    }

    public Hero getHero() {
        return this.hero;
    }

}
