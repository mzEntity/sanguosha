package org.example.game.logic.action.use.undelayed;

import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.action.play.PlaySB02Action;
import org.example.game.logic.action.require.RequirePlaySB02Action;
import org.example.game.logic.action.require.RequireUseSB02Action;
import org.example.game.logic.action.role.GainHealthAction;
import org.example.game.logic.action.role.InjurySettleAction;
import org.example.game.logic.action.use.AskAndUseSUS09Process;
import org.example.game.logic.action.use.UseSB02Action;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class UseSUS02Action extends Action {
    private Role subject;
    private List<Role> targets;
    private LogicCard logicCard;

    public UseSUS02Action(Role subject, List<Role> targets, LogicCard logicCard) {
        super();
        this.subject = subject;
        this.targets = targets;
        this.logicCard = logicCard;
    }

    @Override
    protected void mainLogic(Action from) {
        new MoveToDiscardAreaAction(this.logicCard.getPhysicalCard()).process(this);
        for(Role target : targets) {
            Logger.printf("[万箭齐发]: %s指定%s为目标\n", this.subject.code, target.code);
            AskAndUseSUS09Process a = new AskAndUseSUS09Process(this, this.logicCard);
            a.process();
            if (a.getResult() != null) {
                continue;
            }
            RequirePlaySB02Action r = new RequirePlaySB02Action(target);
            r.process(this);
            if (r.getResult() != null) {
                new PlaySB02Action(target, r.getResult()).process(this);
            } else {
                new InjurySettleAction(this.subject, target).process(this);
            }
        }
    }
}
