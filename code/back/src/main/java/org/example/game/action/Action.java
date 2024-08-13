package org.example.game.action;

import org.example.game.role.Role;

import java.util.List;

public abstract class Action {

    protected Role subject;

    public Action(Role subject) {
        this.subject = subject;
    }

    public void process(Action from){
        this.mainLogic(from);
    }

    abstract protected void mainLogic(Action from);
}
