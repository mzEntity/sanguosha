package org.example.game.action.stage;

import org.example.game.role.Role;
import org.example.game.action.Action;
import org.example.log.Logger;

public class DrawStage extends Action {
    private static final int DEFAULT_DRAW_NUM = 2;
    public DrawStage(Role subject) {
        super("DrawStage", subject);
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("DrawStage:摸牌阶段\n");
        new DrawCardAction(this.subject, DEFAULT_DRAW_NUM).process(this);
    }
}
