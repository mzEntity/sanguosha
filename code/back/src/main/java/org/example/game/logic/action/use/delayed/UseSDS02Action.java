package org.example.game.logic.action.use.delayed;

import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToDivinationAreaAction;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class UseSDS02Action extends Action {
    private final Role subject;
    private final Role target;
    private final LogicCard logicCard;

    public UseSDS02Action(Role subject, Role target, LogicCard logicCard) {
        super();
        this.subject = subject;
        this.target = target;
        this.logicCard = logicCard;
    }

    @Override
    protected void mainLogic(Action from) {
        new MoveToDivinationAreaAction(this.target, logicCard).process(this);
    }

    public Role getSubject() {
        return subject;
    }

    public Role getTarget() {
        return target;
    }

    public LogicCard getLogicCard() {
        return logicCard;
    }
}
