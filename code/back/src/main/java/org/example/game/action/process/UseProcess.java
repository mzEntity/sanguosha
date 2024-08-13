package org.example.game.action.process;

import org.example.game.action.Action;
import org.example.game.action.TriggerIdentifier;
import org.example.game.action.TriggerTable;
import org.example.game.board.card.logic.LogicCard;
import org.example.game.role.Role;

import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/12
 */
public class UseProcess extends Action {
    private List<Role> targets;
    private LogicCard logicCard;

    public UseProcess(Role subject, List<Role> targets, LogicCard logicCard) {
        super(subject);
        this.targets = targets;
        this.logicCard = logicCard;
    }

    @Override
    protected void mainLogic(Action from) {
        TriggerTable.processBefore(this, TriggerIdentifier.build("USE_" + logicCard.getId() + "_" + subject.code));
        TriggerTable.processBefore(this, TriggerIdentifier.build("TARGET_" + logicCard.getId() + "_" + subject.code));
        for(Role target : targets) {
            TriggerTable.processBefore(this, TriggerIdentifier.build("SPEC_" + logicCard.getId() + "_" + target.code));
        }

        TriggerTable.processAfter(this, TriggerIdentifier.build("TARGET_" + logicCard.getId() + "_" + subject.code));
        for(Role target : targets) {
            TriggerTable.processAfter(this, TriggerIdentifier.build("SPEC_" + logicCard.getId() + "_" + target.code));
        }
        TriggerTable.processBefore(this, TriggerIdentifier.build("WORK_" + logicCard.getId() + "_" + subject.code));
        this.logicCard.process(this, this.subject, this.targets);
        TriggerTable.processAfter(this, TriggerIdentifier.build("WORK_" + logicCard.getId() + "_" + subject.code));
    }
}
