package org.example.game.action.stage;

import org.example.game.role.Role;
import org.example.game.action.Action;
import org.example.log.Logger;

public class PreparationStage extends Action {
    public PreparationStage(Role subject) {
        super(subject);
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("PreparationStage:准备阶段\n");
    }
}
