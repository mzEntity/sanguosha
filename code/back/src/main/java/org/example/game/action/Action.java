package org.example.game.action;

import org.example.game.role.Role;

import java.util.List;

public abstract class Action {

    protected Role subject;
    protected String code;
    protected TriggerIdentifier triggerId;

    public Action(String code, Role subject) {
        this.code = code;
        this.subject = subject;
        if(this.subject == null){
            this.triggerId = TriggerIdentifier.build(code);
        } else {
            this.triggerId = TriggerIdentifier.build(code + "_" + subject.code);
        }
    }

    public void process(Action from){
        this.notifyBefore();
        this.mainLogic(from);
        this.notifyAfter();
    }

    abstract protected void mainLogic(Action from);

    public void registerBefore(Action target){
        TriggerTable.registerBefore(this.triggerId, target);
    }

    public void registerAfter(Action target){
        TriggerTable.registerAfter(this.triggerId, target);
    }

    protected void notifyBefore(){
        TriggerTable.processBefore(this, this.triggerId);
    }

    protected void notifyAfter(){
        TriggerTable.processAfter(this, this.triggerId);
    }
}
