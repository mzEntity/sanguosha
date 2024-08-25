package org.example.game.logic.action.use;

import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.action.require.RequireUseSB02Action;
import org.example.game.logic.action.role.GainHealthAction;
import org.example.game.logic.action.role.InjurySettleAction;
import org.example.game.role.Role;

import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class UseSB03Action extends Action {
    private final Role subject;
    private final List<Role> targets;
    private final LogicCard logicCard;

    public UseSB03Action(Role subject, List<Role> targets, LogicCard logicCard) {
        super();
        this.subject = subject;
        this.targets = targets;
        this.logicCard = logicCard;
    }

    @Override
    protected void mainLogic(Action from) {
        new MoveToDiscardAreaAction(this.logicCard.getDeck()).process(this);
        for(Role target : targets) {
            new GainHealthAction(this.subject, target, 1).process(this);
        }
    }
}
