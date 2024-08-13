package org.example.game.action.stage;

import org.example.game.action.Action;
import org.example.game.role.Role;
import org.example.log.Logger;

public class TurnStartStage extends Action {

    public TurnStartStage(Role subject) {
        super("TurnStartStage", subject);
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("TurnStartStage:回合开始阶段\n");
    }
}
