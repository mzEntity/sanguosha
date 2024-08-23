package org.example.game.logic.action.use.undelayed;

import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.action.use.AskAndUseSUS09Process;
import org.example.game.role.Role;
import org.example.log.Logger;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class UseSUS09Action extends Action{
    private Role subject;
    private LogicCard targetSkill;
    private LogicCard logicCard;
    private boolean beOffset;

    public UseSUS09Action(Role subject, LogicCard target, LogicCard logicCard) {
        this.subject = subject;
        this.targetSkill = target;
        this.logicCard = logicCard;
        this.beOffset = false;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("%s使用一张[无懈可击]用于抵消%s的效果\n", this.subject.code, targetSkill.getLogicCard().toString());
        new MoveToDiscardAreaAction(this.logicCard.getPhysicalCard()).process(this);
        AskAndUseSUS09Process a = new AskAndUseSUS09Process(this, this.logicCard);
        a.process();
        this.beOffset = (a.getResult() != null);
    }

    public boolean isOffset() {
        return beOffset;
    }
}
