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
public class SDS01DivinationAction extends DivinationAction{
    private LogicCard logicCard;

    public SDS01DivinationAction(Role subject, LogicCard logicCard) {
        super(subject);
        this.logicCard = logicCard;
    }

    @Override
    protected void doWithResults() {
        if(this.isMet(new CompositeAndRequirement(
                new ArrayList<>(Arrays.asList(
                        new IsSpecificSuitRequirement(Suit.Spade),
                        new IsPointGreaterThanRequirement(1),
                        new IsPointLessThanRequirement(10)
                ))
        ))){
            new InjurySettleAction(null, this.subject, 3).process(this);
            new MoveToDiscardAreaAction(this.result).process(this);
            new MoveToDiscardAreaAction(logicCard.getPhysicalCard()).process(this);
        } else {
            new MoveToDiscardAreaAction(this.result).process(this);
            new MoveToDivinationAreaAction(Game.getAliveNext(this.subject), logicCard).process(this);
        }
    }
}
