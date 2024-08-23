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
    private Role by;
    private Role to;

    public GainHealthAction(Role subject, Role target) {
        super();
        this.by = subject;
        this.to = target;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("%s让%s回复一点体力值\n", this.by.code, this.to.code);
        if(this.to.isFullBlood()){
            System.err.println("满血状态，出错了");
            return;
        }
        this.to.gainHp(1);
    }
}
