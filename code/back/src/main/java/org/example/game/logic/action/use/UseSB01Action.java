package org.example.game.logic.action.use;

import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.action.require.RequireUseSB02Action;
import org.example.game.logic.action.role.InjurySettleAction;
import org.example.game.role.Role;

import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/22
 */
public class UseSB01Action extends Action {
    private Role subject;
    private List<Role> targets;
    private LogicCard logicCard;

    public UseSB01Action(Role subject, List<Role> targets, LogicCard logicCard) {
        super();
        this.subject = subject;
        this.targets = targets;
        this.logicCard = logicCard;
    }

    @Override
    protected void mainLogic(Action from) {
        for(Role target : targets) {
            RequireUseSB02Action r = new RequireUseSB02Action(target);
            r.process(this);
            if(r.getResult() != null){
                new UseSB02Action(target, this.logicCard, r.getResult()).process(this);
            }
            new InjurySettleAction(this.subject, target, 1).process(this);
        }
        new MoveToDiscardAreaAction(this.logicCard.getDeck()).process(this);
    }

    public Role getSubject() {
        return subject;
    }

    public List<Role> getTargets() {
        return targets;
    }

    public LogicCard getLogicCard() {
        return logicCard;
    }
}
