package org.example.game.logic.action.use.undelayed;

import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.process.PollAndUseSUS09Process;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class UseSUS09Action extends Action{
    private final Role subject;
    private final LogicCard targetSkill;
    private final LogicCard logicCard;
    private boolean beOffset;

    public UseSUS09Action(Role subject, LogicCard target, LogicCard logicCard) {
        this.subject = subject;
        this.targetSkill = target;
        this.logicCard = logicCard;
        this.beOffset = false;
    }

    @Override
    protected void mainLogic(Action from) {
        PollAndUseSUS09Process a = new PollAndUseSUS09Process(this.logicCard);
        a.process(this);
        this.beOffset = (a.getResult() != null);
        new MoveToDiscardAreaAction(this.logicCard.getDeck()).process(this);
    }

    public boolean isOffset() {
        return beOffset;
    }

    public Role getSubject() {
        return subject;
    }

    public LogicCard getTargetSkill() {
        return targetSkill;
    }

    public LogicCard getLogicCard() {
        return logicCard;
    }
}
