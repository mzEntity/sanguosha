package org.example.game.logic.trigger;

import org.example.game.logic.Action;

import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/22
 */
public class TriggerManager {
    private static TriggerTable triggerTable = new TriggerTable();

    public static void trigger(TriggerIdentifier tid, Action from){
        List<Action> actionBefore = triggerTable.getActions(tid);
        for(Action action : actionBefore){
            action.process(from);
        }
    }

    public static void register(TriggerIdentifier tid, Action target){
        triggerTable.register(tid, target);
    }
}
