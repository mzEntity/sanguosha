package org.example.game.logic.action.role;

import org.example.game.logic.Action;
import org.example.game.logic.process.DyingProcess;
import org.example.game.logic.trigger.TriggerBuilder;
import org.example.game.logic.trigger.TriggerManager;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/12
 */
public class InjurySettleAction extends Action {
    private final Role by;
    private final Role to;
    private final int hpBefore;
    private final int count;

    public InjurySettleAction(Role subject, Role target, int count) {
        super();
        this.by = subject;
        this.to = target;
        this.hpBefore = target.condition.hp;
        this.count = count;
    }

    @Override
    protected void mainLogic(Action from) {
        this.to.loseHp(this.count);
        boolean isDying = this.to.isDying();
        if(isDying){
            new DyingProcess(this.to).process(this);
        }
        TriggerManager.trigger(TriggerBuilder.getHurtTrigger(this.to), this);
    }

    public Role getBy() {
        return by;
    }

    public Role getTo() {
        return to;
    }

    public int getCount() {
        return count;
    }

    public int getHpBefore() {
        return hpBefore;
    }
}
