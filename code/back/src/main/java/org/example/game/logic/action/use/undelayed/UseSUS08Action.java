package org.example.game.logic.action.use.undelayed;

import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.action.play.PlaySB01Action;
import org.example.game.logic.action.require.RequirePlaySB01Action;
import org.example.game.logic.action.role.InjurySettleAction;
import org.example.game.logic.action.use.PollAndUseSUS09Process;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class UseSUS08Action extends Action {
    private Role subject;
    private List<Role> targets;
    private LogicCard logicCard;

    public UseSUS08Action(Role subject, List<Role> targets, LogicCard logicCard) {
        super();
        this.subject = subject;
        this.targets = targets;
        this.logicCard = logicCard;
    }

    @Override
    protected void mainLogic(Action from) {
        new MoveToDiscardAreaAction(this.logicCard.getPhysicalCard()).process(this);
        for(Role target : targets) {
            Logger.printf("[南蛮入侵]: %s指定%s为目标\n", this.subject.code, target.code);
            PollAndUseSUS09Process a = new PollAndUseSUS09Process(this, this.logicCard);
            a.process();
            if (a.getResult() != null) {
                continue;
            }
            RequirePlaySB01Action r = new RequirePlaySB01Action(target);
            r.process(this);
            if (r.getResult() != null) {
                new PlaySB01Action(target, r.getResult()).process(this);
            } else {
                new InjurySettleAction(this.subject, target, 1).process(this);
            }
        }
    }
}
