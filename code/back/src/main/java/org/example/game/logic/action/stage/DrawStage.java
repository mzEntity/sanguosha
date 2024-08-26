package org.example.game.logic.action.stage;

import org.example.game.logic.action.card.GetCardFromDrawAreaAction;
import org.example.game.logic.action.global.SelectFromDrawAreaAction;
import org.example.game.logic.process.DrawCardProcess;
import org.example.game.role.Role;
import org.example.game.logic.Action;

public class DrawStage extends RoleStage {
    private static final int DEFAULT_DRAW_NUM = 2;
    public DrawStage(Role subject) {
        super(subject);
    }

    @Override
    protected void mainLogic(Action from) {
        new DrawCardProcess(this.subject, DEFAULT_DRAW_NUM).process(this);
    }
}
