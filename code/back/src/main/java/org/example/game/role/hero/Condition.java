package org.example.game.role.hero;

public class Condition {
    public int hpMax;
    public int hp;

    public boolean alive;

    public Condition(int hpMax, int hp) {
        this.hpMax = hpMax;
        this.hp = hp;
        this.alive = true;
    }

    public boolean isHurt(){
        return hpMax > hp;
    }
}
