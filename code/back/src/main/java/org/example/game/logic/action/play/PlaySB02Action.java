package org.example.game.logic.action.play;

import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class PlaySB02Action extends Action {
    private final Role subject;
    private final LogicCard targetSB02;

    public PlaySB02Action(Role subject, LogicCard targetSB02) {
        super();
        this.subject = subject;
        this.targetSB02 = targetSB02;
    }

    @Override
    protected void mainLogic(Action from) {
        new MoveToDiscardAreaAction(this.targetSB02.getDeck()).process(this);
    }

    public Role getSubject() {
        return subject;
    }

    public LogicCard getTargetSB02() {
        return targetSB02;
    }
}
