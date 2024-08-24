package org.example.game.logic.action.stage;

import org.example.game.role.Role;
import org.example.game.logic.Action;
import org.example.log.Logger;

public class PreparationStage extends RoleStage {
    public PreparationStage(Role subject) {
        super(subject);
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("PreparationStage:准备阶段\n");
    }
}
