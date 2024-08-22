package org.example.game.logic.action.stage;

import org.example.game.role.Role;
import org.example.game.logic.Action;
import org.example.log.Logger;

public class DivinationStage extends Action {
    private Role subject;
    public DivinationStage(Role subject) {
        super();
        this.subject = subject;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("DivinationStage:判定阶段\n");
    }
}
