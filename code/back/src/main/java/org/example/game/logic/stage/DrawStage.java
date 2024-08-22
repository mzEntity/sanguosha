package org.example.game.logic.stage;

import org.example.game.logic.action.card.DrawCardAction;
import org.example.game.role.Role;
import org.example.game.logic.Action;
import org.example.log.Logger;

public class DrawStage extends Action {
    private Role subject;
    private static final int DEFAULT_DRAW_NUM = 2;
    public DrawStage(Role subject) {
        super();
        this.subject = subject;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("DrawStage:摸牌阶段\n");
        new DrawCardAction(this.subject, DEFAULT_DRAW_NUM).process(this);
    }
}
