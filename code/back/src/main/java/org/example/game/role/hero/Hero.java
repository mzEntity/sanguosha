package org.example.game.role.hero;

public class Hero {
    public Condition condition;
    public String description;

    public Hero(int hpMax, String description) {
        // 测试，开局受伤
        this.condition = new Condition(hpMax, hpMax - 1);
        this.description = description;
    }

    public int getHandLimit(){
        return this.condition.hp;
    }
}
