package org.example.game.logic.action.role;

import org.example.game.logic.Action;
import org.example.game.logic.trigger.TriggerBuilder;
import org.example.game.logic.trigger.TriggerManager;
import org.example.game.role.Role;
import org.example.log.Logger;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class GainHealthAction extends Action {
    private final Role by;
    private final Role to;
    private final int count;

    public GainHealthAction(Role subject, Role target, int count) {
        super();
        this.by = subject;
        this.to = target;
        this.count = count;
    }

    @Override
    protected void mainLogic(Action from) {
        if(this.to.isFullBlood()){
            System.err.println("满血状态，出错了");
            return;
        }
        int gainCount = Math.min(this.to.getHpLost(), this.count);
        Logger.printf("%s让%s回复%d点体力值\n", this.by, this.to, gainCount);
        this.to.gainHp(gainCount);
    }
}
