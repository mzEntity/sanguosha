package org.example.game.logic;

import java.util.ArrayList;
import java.util.List;

public abstract class Action {

    public Action() {
    }

    public void process(Action from){
        this.mainLogic(from);
    }

    abstract protected void mainLogic(Action from);

}
