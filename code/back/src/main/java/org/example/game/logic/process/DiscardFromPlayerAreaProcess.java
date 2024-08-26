package org.example.game.logic.process;

import org.example.game.logic.Action;
import org.example.game.logic.LogicProcess;
import org.example.game.logic.action.role.ChooseFromPlayerAreaProcess;
import org.example.game.logic.action.role.DiscardFromPlayerAreaAction;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/26
 */
public class DiscardFromPlayerAreaProcess extends LogicProcess {
    private final Role by;
    private final Role to;
    private final int count;

    public DiscardFromPlayerAreaProcess(Role subject, Role target, int count) {
        super();
        this.by = subject;
        this.to = target;
        this.count = count;
    }

    @Override
    public void process(Action from) {
        ChooseFromPlayerAreaProcess c = new ChooseFromPlayerAreaProcess(this.by, this.to, this.count);
        c.process();
        new DiscardFromPlayerAreaAction(this.by, this.to, c.getResult()).process(from);
    }
}
