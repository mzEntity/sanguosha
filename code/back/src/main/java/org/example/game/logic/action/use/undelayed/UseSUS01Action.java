package org.example.game.logic.action.use.undelayed;

import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.action.role.GainHealthAction;
import org.example.game.logic.process.PollAndUseSUS09Process;
import org.example.game.role.Role;

import java.util.List;

/**
 * @Description: 使用桃园结义
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class UseSUS01Action extends Action {
    private final Role subject;
    private final List<Role> targets;
    private final LogicCard logicCard;

    public UseSUS01Action(Role subject, List<Role> targets, LogicCard logicCard) {
        super();
        this.subject = subject;
        this.targets = targets;
        this.logicCard = logicCard;
    }

    @Override
    protected void mainLogic(Action from) {
        for(Role target : targets) {
            if(target.isFullBlood()){
                continue;
            }
            PollAndUseSUS09Process a = new PollAndUseSUS09Process(this.logicCard);
            a.process(this);
            if(a.getResult() != null){
                continue;
            }
            new GainHealthAction(this.subject, target, 1).process(this);
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
