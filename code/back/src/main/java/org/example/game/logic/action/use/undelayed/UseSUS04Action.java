package org.example.game.logic.action.use.undelayed;

import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.action.role.ChooseFromPlayerAreaProcess;
import org.example.game.logic.action.role.GetCardFromPlayerAreaAction;
import org.example.game.logic.process.PollAndUseSUS09Process;
import org.example.game.role.Role;

import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class UseSUS04Action extends Action {
    private final Role subject;
    private final List<Role> targets;
    private final LogicCard logicCard;

    public UseSUS04Action(Role subject, List<Role> targets, LogicCard logicCard) {
        super();
        this.subject = subject;
        this.targets = targets;
        this.logicCard = logicCard;
    }

    @Override
    protected void mainLogic(Action from) {
        for(Role target : targets) {
            PollAndUseSUS09Process a = new PollAndUseSUS09Process(this.logicCard);
            a.process(this);
            if(a.getResult() != null){
                continue;
            }
            ChooseFromPlayerAreaProcess c = new ChooseFromPlayerAreaProcess(this.subject, target, 1);
            c.process();
            new GetCardFromPlayerAreaAction(this.subject, target, c.getResult()).process(this);
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
