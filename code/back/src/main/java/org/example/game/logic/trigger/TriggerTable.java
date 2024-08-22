package org.example.game.logic.trigger;

import org.example.game.logic.Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/5
 */
public class TriggerTable {
    private final HashMap<TriggerIdentifier, TriggerTable> nextStage;
    private final HashMap<TriggerIdentifier, List<Action>> actions;

    TriggerTable() {
        this.nextStage = new HashMap<>();
        this.actions = new HashMap<>();
    }

    void register(TriggerIdentifier trigger, Action target){
        this.myRegister(trigger, target);
    }

    List<Action> getActions(TriggerIdentifier trigger){
        return this.myGetActions(trigger);
    }

    private void myRegister(TriggerIdentifier trigger, Action target){
        TriggerIdentifier next = trigger.getNext();
        if(next != null){
            if(!this.nextStage.containsKey(trigger)){
                this.nextStage.put(trigger, new TriggerTable());
            }
            this.nextStage.get(trigger).myRegister(next, target);
        } else {
            if(!this.actions.containsKey(trigger)){
                this.actions.put(trigger, new ArrayList<>());
            }
            this.actions.get(trigger).add(target);
        }
    }

    private List<Action> myGetActions(TriggerIdentifier trigger){
        List<Action> current = this.actions.get(trigger);
        if(current == null){
            current = new ArrayList<>();
        }
        List<Action> result = new ArrayList<>(current);

        TriggerIdentifier next = trigger.getNext();
        TriggerTable nextTable = this.nextStage.get(trigger);
        if(next != null && nextTable != null){
            List<Action> nextActions = nextTable.myGetActions(next);
            result.addAll(nextActions);
        }
        return result;
    }
    

    public static void main(String[] args) {
        TriggerTable triggerTable = new TriggerTable();
        TriggerIdentifier tid1_sub1 = TriggerBuilder.build("TID1_SUB1");
        TriggerIdentifier tid2_sub1 = TriggerBuilder.build("TID2_SUB1");
        TriggerIdentifier tid1 = TriggerBuilder.build("TID1");
        TriggerIdentifier tid3 = TriggerBuilder.build("TID3");

        Action action = new Action() {
            @Override
            public void process(Action from) {
                super.process(from);
            }

            @Override
            protected void mainLogic(Action from) {
            }

        };
        triggerTable.register(tid1_sub1, action);
        triggerTable.register(tid2_sub1, action);
        triggerTable.register(tid1, action);
        triggerTable.register(tid3, action);

        List<Action> tid1_actions = triggerTable.getActions(tid1);
        System.out.println(tid1_actions.size());
        List<Action> tid1_sub1_actions = triggerTable.getActions(tid1_sub1);
        System.out.println(tid1_sub1_actions.size());
        List<Action> tid2_sub1_actions = triggerTable.getActions(tid2_sub1);
        System.out.println(tid2_sub1_actions.size());
        List<Action> tid2_actions = triggerTable.getActions(TriggerBuilder.build("TID2"));
        System.out.println(tid2_actions.size());
        List<Action> tid3_actions = triggerTable.getActions(tid3);
        System.out.println(tid3_actions.size());

        TriggerIdentifier tid1_sub2 = TriggerBuilder.build("TID1_SUB2");
        List<Action> tid1_sub2_actions = triggerTable.getActions(tid1_sub2);
        System.out.println(tid1_sub2_actions.size());
    }
}
