package org.example.game.logic;

public abstract class Action {
    public Action() {
    }

    public void process(Action from){
        this.mainLogic(from);
    }

    abstract protected void mainLogic(Action from);
}
