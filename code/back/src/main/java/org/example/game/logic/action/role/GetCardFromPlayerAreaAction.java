package org.example.game.logic.action.role;

import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToHandAreaAction;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class GetCardFromPlayerAreaAction extends Action {
    private Role by;
    private Role to;
    private int count;

    public GetCardFromPlayerAreaAction(Role subject, Role target, int count) {
        super();
        this.by = subject;
        this.to = target;
        this.count = count;
    }

    @Override
    protected void mainLogic(Action from) {
        ChooseFromPlayerAreaProcess c = new ChooseFromPlayerAreaProcess(this.by, this.to, this.count);
        c.process();
        new MoveToHandAreaAction(this.by, c.getResult()).process(this);
    }
}
