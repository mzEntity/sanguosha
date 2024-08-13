package org.example.game.role.hero;

public class Condition {
    public int hpMax;
    public int hp;
    public boolean isAlive;

    public Condition(int hpMax, int hp) {
        this.hpMax = hpMax;
        this.hp = hp;
        this.isAlive = true;
    }

    public boolean isHurt(){
        return hpMax > hp;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
