package org.example.game.logic.action.divination;

import org.example.game.Game;
import org.example.game.board.card.Suit;
import org.example.game.board.card.deck.Deck;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.Turn;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.action.card.MoveToDivinationAreaAction;
import org.example.game.logic.action.role.InjurySettleAction;
import org.example.game.logic.action.use.PollAndUseSUS09Process;
import org.example.game.requirement.CardRequirement;
import org.example.game.requirement.CompositeAndRequirement;
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
public class SDS01DivinationAction extends Action{
    private final LogicCard targetSDS01;
    private final Role subject;

    private static final CardRequirement workRequirement;

    static {
        workRequirement = new CompositeAndRequirement(
                new ArrayList<>(Arrays.asList(
                        new IsSpecificSuitRequirement(Suit.Spade),
                        new IsPointGreaterThanRequirement(1),
                        new IsPointLessThanRequirement(10)
                ))
        );
    }

    public SDS01DivinationAction(Role subject, LogicCard targetSDS01) {
        super();
        this.subject = subject;
        this.targetSDS01 = targetSDS01;
    }

    @Override
    public void mainLogic(Action from) {
        PollAndUseSUS09Process p = new PollAndUseSUS09Process(this, this.targetSDS01);
        p.process();
        if(p.getResult() == null){
            DivinationAction divination = new DivinationAction(this.subject);
            divination.process(this);
            if(divination.isMet(workRequirement)){
                new InjurySettleAction(null, this.subject, 3).process(this);
                new MoveToDiscardAreaAction(divination.getResult()).process(this);
                new MoveToDiscardAreaAction(this.targetSDS01.getDeck()).process(this);
                return;
            }
            new MoveToDiscardAreaAction(divination.getResult()).process(this);
        }
        new MoveToDivinationAreaAction(Game.getAliveNext(this.subject), this.targetSDS01).process(this);
    }
}
