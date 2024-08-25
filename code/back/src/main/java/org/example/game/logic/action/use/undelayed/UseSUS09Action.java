package org.example.game.logic.action.use.undelayed;

import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.action.use.PollAndUseSUS09Process;
import org.example.game.role.Role;
import org.example.log.Logger;

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
        Logger.printf("%s使用一张[无懈可击]用于抵消%s的效果\n", this.subject.code, targetSkill.getLogicRepresentation().getCid());
        new MoveToDiscardAreaAction(this.logicCard.getDeck()).process(this);
        PollAndUseSUS09Process a = new PollAndUseSUS09Process(this, this.logicCard);
        a.process();
        this.beOffset = (a.getResult() != null);
    }

    public boolean isOffset() {
        return beOffset;
    }
}
