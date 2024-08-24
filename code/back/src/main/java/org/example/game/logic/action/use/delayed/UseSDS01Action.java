package org.example.game.logic.action.use.delayed;

import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.action.card.MoveToDivinationAreaAction;
import org.example.game.logic.action.role.InjurySettleAction;
import org.example.game.logic.action.use.PollAndUseSUS09Process;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class UseSDS01Action extends Action {
    private Role subject;
    private Role target;
    private LogicCard logicCard;

    public UseSDS01Action(Role subject, Role target, LogicCard logicCard) {
        super();
        this.subject = subject;
        this.target = target;
        this.logicCard = logicCard;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("[闪电]: %s指定%s为目标\n", this.subject.code, target.code);
        new MoveToDivinationAreaAction(this.target, logicCard).process(this);
    }
}
