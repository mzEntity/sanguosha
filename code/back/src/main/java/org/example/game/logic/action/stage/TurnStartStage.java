package org.example.game.logic.action.stage;

import org.example.game.logic.Action;
import org.example.game.role.Role;
import org.example.log.Logger;

public class TurnStartStage extends RoleStage {
    public TurnStartStage(Role subject) {
        super(subject);
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("TurnStartStage:回合开始阶段\n");
    }
}
