package org.example.game.logic.action.divination;

import org.example.game.board.card.Suit;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.Turn;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.action.use.PollAndUseSUS09Process;
import org.example.game.requirement.CardRequirement;
import org.example.game.requirement.CompositeAndRequirement;
import org.example.game.requirement.NotRequirement;
import org.example.game.requirement.subrequirement.IsPointGreaterThanRequirement;
import org.example.game.requirement.subrequirement.IsPointLessThanRequirement;
import org.example.game.requirement.subrequirement.IsSpecificSuitRequirement;
import org.example.game.role.Role;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class SDS02DivinationAction extends Action {
    private final LogicCard targetSDS02;
    private final Role subject;

    private static final CardRequirement workRequirement;

    static {
        workRequirement = new NotRequirement(
                new IsSpecificSuitRequirement(Suit.Heart)
        );
    }

    public SDS02DivinationAction(Role subject, LogicCard targetSDS02) {
        super();
        this.subject = subject;
        this.targetSDS02 = targetSDS02;
    }

    @Override
    protected void mainLogic(Action from) {
        PollAndUseSUS09Process p = new PollAndUseSUS09Process(this, this.targetSDS02);
        p.process();
        if(p.getResult() == null){
            DivinationAction divination = new DivinationAction(this.subject);
            divination.process(this);
            if(divination.isMet(workRequirement)){
                Turn turn = this.subject.getCurrentTurn();
                turn.getPunchingStage().setSkipped(true);
            }
            new MoveToDiscardAreaAction(divination.getResult()).process(this);
        }
        new MoveToDiscardAreaAction(this.targetSDS02.getDeck()).process(this);
    }
}
