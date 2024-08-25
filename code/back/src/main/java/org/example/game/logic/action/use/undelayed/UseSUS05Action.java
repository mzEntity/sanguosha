package org.example.game.logic.action.use.undelayed;

import org.example.game.board.card.deck.Deck;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.action.card.MoveToHandAreaAction;
import org.example.game.logic.action.global.SelectFromDrawAreaAction;
import org.example.game.logic.action.role.AskToSelectFromDeckProcess;
import org.example.game.logic.action.role.GainHealthAction;
import org.example.game.logic.action.use.PollAndUseSUS09Process;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class UseSUS05Action extends Action {
    private final Role subject;
    private final List<Role> targets;
    private final LogicCard logicCard;

    public UseSUS05Action(Role subject, List<Role> targets, LogicCard logicCard) {
        super();
        this.subject = subject;
        this.targets = targets;
        this.logicCard = logicCard;
    }

    @Override
    protected void mainLogic(Action from) {
        new MoveToDiscardAreaAction(this.logicCard.getDeck()).process(this);
        int count = this.targets.size();
        SelectFromDrawAreaAction s = new SelectFromDrawAreaAction(count);
        s.process(this);
        Deck table = s.getSelectResult();
        for(Role target : targets) {
            Logger.printf("[五谷丰登]: %s指定%s为目标\n", this.subject, target);
            PollAndUseSUS09Process a = new PollAndUseSUS09Process(this, this.logicCard);
            a.process();
            if(a.getResult() != null){
                continue;
            }
            AskToSelectFromDeckProcess chooseProcess = new AskToSelectFromDeckProcess(target, table, 1);
            chooseProcess.process();
            new MoveToHandAreaAction(target, chooseProcess.getResult()).process(this);
        }
    }
}
