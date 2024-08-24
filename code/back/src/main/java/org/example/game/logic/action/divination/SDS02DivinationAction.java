package org.example.game.logic.action.divination;

import org.example.game.board.card.Suit;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.Turn;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.requirement.subrequirement.IsSpecificSuitRequirement;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class SDS02DivinationAction extends DivinationAction {
    private LogicCard logicCard;

    public SDS02DivinationAction(Role subject, LogicCard logicCard) {
        super(subject);
        this.logicCard = logicCard;
    }

    @Override
    protected void doWithResults() {
        if(!this.isMet(new IsSpecificSuitRequirement(Suit.Heart))){
            Turn turn = this.subject.getCurrentTurn();
            turn.getPunchingStage().setSkipped(true);
        }
        new MoveToDiscardAreaAction(this.result).process(this);
        new MoveToDiscardAreaAction(this.logicCard.getPhysicalCard()).process(this);
    }
}
