package org.example.game.action.stage;

import org.example.game.role.Role;
import org.example.game.action.Action;
import org.example.log.Logger;

public class TurnFinishStage extends Action {
    public TurnFinishStage(Role subject) {
        super(subject);
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("TurnFinishStage:回合结束阶段\n");
    }
}
