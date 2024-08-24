package org.example.game.logic.action.use.undelayed;

import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.DrawCardAction;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.action.role.GainHealthAction;
import org.example.game.logic.action.use.PollAndUseSUS09Process;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class UseSUS07Action extends Action {
    private Role subject;
    private List<Role> targets;
    private LogicCard logicCard;

    public UseSUS07Action(Role subject, List<Role> targets, LogicCard logicCard) {
        super();
        this.subject = subject;
        this.targets = targets;
        this.logicCard = logicCard;
    }

    @Override
    protected void mainLogic(Action from) {
        new MoveToDiscardAreaAction(this.logicCard.getPhysicalCard()).process(this);
        for(Role target : targets) {
            Logger.printf("[无中生有]: %s指定%s为目标\n", this.subject.code, target.code);
            PollAndUseSUS09Process a = new PollAndUseSUS09Process(this, this.logicCard);
            a.process();
            if(a.getResult() != null){
                continue;
            }
            new DrawCardAction(target, 2).process(this);
        }
    }
}