package org.example.game.action.process;

import org.example.game.action.Action;
import org.example.game.action.TriggerIdentifier;
import org.example.game.action.TriggerTable;
import org.example.game.board.card.logic.LogicCard;
import org.example.game.role.Role;
import org.example.log.Logger;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class DyingProcess extends Action {

    public DyingProcess(Role subject) {
        super(subject);
    }

    @Override
    protected void mainLogic(Action from) {
        TriggerTable.processBefore(this, TriggerIdentifier.build("ENTERDYING_" + subject.code));
        TriggerTable.processBefore(this, TriggerIdentifier.build("STAYDYING_" + subject.code));

        boolean isDead = this.subject.isDying();
        if(isDead){
            Logger.printf("玩家%s死亡\n", this.subject.code);
            this.subject.die();
            TriggerTable.processBefore(this, TriggerIdentifier.build("DEAD_" + subject.code));
        } else {
            TriggerTable.processAfter(this, TriggerIdentifier.build("LEAVEDYING_" + subject.code));
        }
    }
}
