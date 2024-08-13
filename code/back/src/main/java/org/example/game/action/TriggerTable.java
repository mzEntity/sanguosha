package org.example.game.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/5
 */
public class TriggerTable {

    private static final TriggerTable root = new TriggerTable();

    private final HashMap<TriggerIdentifier, TriggerTable> nextStage;
    private final HashMap<TriggerIdentifier, List<Action>> actionBefore;
    private final HashMap<TriggerIdentifier, List<Action>> actionAfter;

    private TriggerTable() {
        this.nextStage = new HashMap<>();
        this.actionBefore = new HashMap<>();
        this.actionAfter = new HashMap<>();
    }

    public static void registerBefore(TriggerIdentifier trigger, Action target){
        root.myRegisterBefore(trigger, target);
    }

    public static void registerAfter(TriggerIdentifier trigger, Action target){
        root.myRegisterAfter(trigger, target);
    }

    public static void processBefore(Action from, TriggerIdentifier trigger) {
        List<Action> actionBefore = getActionBefore(trigger);
        for(Action action : actionBefore){
            action.process(from);
        }
    }

    public static void processAfter(Action from, TriggerIdentifier trigger) {
        List<Action> actionAfter = getActionAfter(trigger);
        for(Action action : actionAfter){
            action.process(from);
        }
    }

    private static List<Action> getActionBefore(TriggerIdentifier trigger){
        return root.myGetActionBefore(trigger);
    }

    private static List<Action> getActionAfter(TriggerIdentifier trigger){
        return root.myGetActionAfter(trigger);
    }



    private void myRegisterBefore(TriggerIdentifier trigger, Action target){
        TriggerIdentifier next = trigger.getNext();
        if(next != null){
            if(!this.nextStage.containsKey(trigger)){
                this.nextStage.put(trigger, new TriggerTable());
            }
            this.nextStage.get(trigger).myRegisterBefore(next, target);
        } else {
            if(!this.actionBefore.containsKey(trigger)){
                this.actionBefore.put(trigger, new ArrayList<>());
            }
            this.actionBefore.get(trigger).add(target);
        }
    }

    private void myRegisterAfter(TriggerIdentifier trigger, Action target){
        TriggerIdentifier next = trigger.getNext();
        if(next != null){
            if(!this.nextStage.containsKey(trigger)){
                this.nextStage.put(trigger, new TriggerTable());
            }
            this.nextStage.get(trigger).myRegisterAfter(next, target);
        } else {
            if(!this.actionAfter.containsKey(trigger)){
                this.actionAfter.put(trigger, new ArrayList<>());
            }
            this.actionAfter.get(trigger).add(target);
        }
    }

    private List<Action> myGetActionBefore(TriggerIdentifier trigger){
        List<Action> current = this.actionBefore.get(trigger);
        if(current == null){
            current = new ArrayList<>();
        }
        List<Action> result = new ArrayList<>(current);

        TriggerIdentifier next = trigger.getNext();
        TriggerTable nextTable = this.nextStage.get(trigger);
        if(next != null && nextTable != null){
            List<Action> nextActions = nextTable.myGetActionBefore(next);
            result.addAll(nextActions);
        }
        return result;
    }

    private List<Action> myGetActionAfter(TriggerIdentifier trigger){
        List<Action> current = this.actionAfter.get(trigger);
        if(current == null){
            current = new ArrayList<>();
        }
        List<Action> result = new ArrayList<>(current);

        TriggerIdentifier next = trigger.getNext();
        TriggerTable nextTable = this.nextStage.get(trigger);
        if(next != null && nextTable != null){
            List<Action> nextActions = nextTable.myGetActionAfter(next);
            result.addAll(nextActions);
        }

        return result;
    }

    public static void main(String[] args) {
        TriggerIdentifier tid1_sub1 = TriggerIdentifier.build("TID1_SUB1");
        TriggerIdentifier tid2_sub1 = TriggerIdentifier.build("TID2_SUB1");
        TriggerIdentifier tid1 = TriggerIdentifier.build("TID1");
        TriggerIdentifier tid3 = TriggerIdentifier.build("TID3");

        Action action = new Action(null) {
            @Override
            public void process(Action from) {
                super.process(from);
            }

            @Override
            protected void mainLogic(Action from) {
            }

        };
        TriggerTable.registerBefore(tid1_sub1, action);
        TriggerTable.registerBefore(tid2_sub1, action);
        TriggerTable.registerBefore(tid1, action);
        TriggerTable.registerBefore(tid3, action);

        List<Action> tid1_actions = TriggerTable.getActionBefore(tid1);
        System.out.println(tid1_actions.size());
        List<Action> tid1_sub1_actions = TriggerTable.getActionBefore(tid1_sub1);
        System.out.println(tid1_sub1_actions.size());
        List<Action> tid2_sub1_actions = TriggerTable.getActionBefore(tid2_sub1);
        System.out.println(tid2_sub1_actions.size());
        List<Action> tid2_actions = TriggerTable.getActionBefore(TriggerIdentifier.build("TID2"));
        System.out.println(tid2_actions.size());
        List<Action> tid3_actions = TriggerTable.getActionBefore(tid3);
        System.out.println(tid3_actions.size());

        TriggerIdentifier tid1_sub2 = TriggerIdentifier.build("TID1_SUB2");
        List<Action> tid1_sub2_actions = TriggerTable.getActionBefore(tid1_sub2);
        System.out.println(tid1_sub2_actions.size());
    }
}
