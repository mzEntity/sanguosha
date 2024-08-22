package org.example.game.logic.action.stage;

import org.example.game.role.Role;
import org.example.game.logic.Action;
import org.example.log.Logger;

public class PreparationStage extends Action {
    private Role subject;
    public PreparationStage(Role subject) {
        super();
        this.subject = subject;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("PreparationStage:准备阶段\n");
    }
}
