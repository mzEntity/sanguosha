package org.example.game.action.stage;

import org.example.game.role.Role;
import org.example.game.action.Action;
import org.example.log.Logger;

public class DivinationStage extends Action {
    public DivinationStage(Role subject) {
        super("DivinationStage", subject);
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("DivinationStage:判定阶段\n");
    }
}
