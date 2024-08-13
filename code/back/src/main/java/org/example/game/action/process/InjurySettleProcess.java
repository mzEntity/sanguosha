package org.example.game.action.process;

import org.example.game.action.Action;
import org.example.game.action.TriggerIdentifier;
import org.example.game.action.TriggerTable;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/12
 */
public class InjurySettleProcess extends Action {
    private Role by;
    private Role to;

    public InjurySettleProcess(Role subject, Role target) {
        super(target);
        this.by = subject;
        this.to = target;
    }

    @Override
    protected void mainLogic(Action from) {
        TriggerTable.processBefore(this, TriggerIdentifier.build("DAMAGE_" + this.by.code));
        TriggerTable.processBefore(this, TriggerIdentifier.build("HURT_" + this.to.code));

        // TODO: 受伤
        this.to.loseHp(1);
        boolean isDying = this.to.isDying();
        if(isDying){
            new DyingProcess(this.to).process(this);
        }

        TriggerTable.processAfter(this, TriggerIdentifier.build("DAMAGE_" + this.by.code));
        TriggerTable.processAfter(this, TriggerIdentifier.build("HURT_" + this.to.code));

        TriggerTable.processBefore(this, TriggerIdentifier.build("SETTLE_" + this.to.code));
        TriggerTable.processAfter(this, TriggerIdentifier.build("SETTLE_" + this.to.code));
    }
}
