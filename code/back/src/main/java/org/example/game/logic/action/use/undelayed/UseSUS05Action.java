package org.example.game.logic.action.use.undelayed;

import org.example.game.board.card.deck.Deck;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.action.card.MoveToHandAreaAction;
import org.example.game.logic.action.global.SelectFromDrawAreaAction;
import org.example.game.logic.action.role.AskToSelectFromDeckProcess;
import org.example.game.logic.process.PollAndUseSUS09Process;
import org.example.game.role.Role;

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
        int count = this.targets.size();
        SelectFromDrawAreaAction s = new SelectFromDrawAreaAction(count);
        s.process(this);
        Deck table = s.getSelectResult();
        for(Role target : targets) {
            PollAndUseSUS09Process a = new PollAndUseSUS09Process(this.logicCard);
            a.process(this);
            if(a.getResult() != null){
                continue;
            }
            AskToSelectFromDeckProcess chooseProcess = new AskToSelectFromDeckProcess(target, table, 1);
            chooseProcess.process();
            new MoveToHandAreaAction(target, chooseProcess.getResult()).process(this);
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
