package org.example.game.logic.stage;

import org.example.game.role.Role;
import org.example.game.logic.Action;
import org.example.log.Logger;

public class TurnFinishStage extends Action {
    private Role subject;
    public TurnFinishStage(Role subject) {
        super();
        this.subject = subject;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("TurnFinishStage:回合结束阶段\n");
    }
}
