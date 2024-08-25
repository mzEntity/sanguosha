package org.example.game.logic.action.role;

import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.action.card.MoveToHandAreaAction;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class DiscardFromPlayerAreaAction extends Action {
    private final Role by;
    private final Role to;
    private final int count;

    public DiscardFromPlayerAreaAction(Role subject, Role target, int count) {
        super();
        this.by = subject;
        this.to = target;
        this.count = count;
    }

    @Override
    protected void mainLogic(Action from) {
        ChooseFromPlayerAreaProcess c = new ChooseFromPlayerAreaProcess(this.by, this.to, this.count);
        c.process();
        new MoveToDiscardAreaAction(c.getResult()).process(this);
    }
}
