package org.example.game.logic.action.divination;

import org.example.game.board.card.Suit;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.Turn;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.action.use.PollAndUseSUS09Process;
import org.example.game.requirement.subrequirement.IsSpecificSuitRequirement;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class SDS02DivinationAction extends Action {
    private LogicCard logicCard;
    private Role subject;

    public SDS02DivinationAction(Role subject, LogicCard logicCard) {
        super();
        this.subject = subject;
        this.logicCard = logicCard;
    }

    @Override
    protected void mainLogic(Action from) {
        PollAndUseSUS09Process p = new PollAndUseSUS09Process(this, this.logicCard);
        p.process();
        if(p.getResult() == null){
            DivinationAction d = new DivinationAction(this.subject);
            d.process(this);
            if(!d.isMet(new IsSpecificSuitRequirement(Suit.Heart))){
                Turn turn = this.subject.getCurrentTurn();
                turn.getPunchingStage().setSkipped(true);
            }
            new MoveToDiscardAreaAction(d.getResult()).process(this);
        }
        new MoveToDiscardAreaAction(this.logicCard.getPhysicalCard()).process(this);
    }
}
