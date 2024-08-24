package org.example.game.logic.action.stage;

import org.example.game.role.Role;
import org.example.game.logic.Action;
import org.example.log.Logger;

public class TurnFinishStage extends RoleStage {
    public TurnFinishStage(Role subject) {
        super(subject);
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("TurnFinishStage:回合结束阶段\n");
    }
}
