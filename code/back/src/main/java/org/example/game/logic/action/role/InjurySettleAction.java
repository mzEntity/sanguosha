package org.example.game.logic.action.role;

import org.example.game.logic.Action;
import org.example.game.logic.trigger.TriggerBuilder;
import org.example.game.logic.trigger.TriggerManager;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/12
 */
public class InjurySettleAction extends Action {
    private Role by;
    private Role to;

    public InjurySettleAction(Role subject, Role target) {
        super();
        this.by = subject;
        this.to = target;
    }

    @Override
    protected void mainLogic(Action from) {
        this.to.loseHp(1);
        boolean isDying = this.to.isDying();
        if(isDying){
            new DyingAction(this.to).process(this);
        }
        TriggerManager.trigger(TriggerBuilder.getHurtTrigger(this.to), this);
    }
}
