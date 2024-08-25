package org.example.game.logic.action.role;

import org.example.game.logic.Action;
import org.example.game.logic.trigger.TriggerBuilder;
import org.example.game.logic.trigger.TriggerManager;
import org.example.game.role.Role;
import org.example.log.Logger;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/12
 */
public class InjurySettleAction extends Action {
    private final Role by;
    private final Role to;
    private final int count;

    public InjurySettleAction(Role subject, Role target, int count) {
        super();
        this.by = subject;
        this.to = target;
        this.count = count;
    }

    @Override
    protected void mainLogic(Action from) {
        if(this.by == null){
            Logger.printf("%s受到无来源的%d点伤害\n", this.to, this.count);
        } else {
            Logger.printf("%s对%s造成%s点伤害\n", this.by, this.to, this.count);
        }
        this.to.loseHp(this.count);
        boolean isDying = this.to.isDying();
        if(isDying){
            new DyingAction(this.to).process(this);
        }
        TriggerManager.trigger(TriggerBuilder.getHurtTrigger(this.to), this);
    }
}
