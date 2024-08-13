package org.example.game.role.hero;

public class Hero {
    private final Condition initCondition;
    public String description;

    public Hero(int initHp, int hpMax, String description) {
        this.initCondition = new Condition(hpMax, initHp);
        this.description = description;
    }

    public Condition getInitCondition() {
        return initCondition;
    }
}
