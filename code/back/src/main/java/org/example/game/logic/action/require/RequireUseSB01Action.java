package org.example.game.logic.action.require;

import org.example.Main;
import org.example.game.board.card.CardIdentifier;
import org.example.game.board.card.deck.Deck;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.requirement.AskToMeetRequirementProcess;
import org.example.game.requirement.subrequirement.IsSpecificCardRequirement;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class RequireUseSB01Action extends Action {
    private final Role subject;
    private final Role target;
    private LogicCard result;

    public RequireUseSB01Action(Role subject, Role target) {
        super();
        this.subject = subject;
        this.target = target;
        this.result = null;
    }

    @Override
    protected void mainLogic(Action from) {
        if(Main.SGS_DEBUG){
            Deck handDeck = this.subject.getHandDeck();
            Deck sb01 = handDeck.getCardDeckIfContain(new IsSpecificCardRequirement("SB01"));
            if(sb01 != null){
                this.result = new LogicCard(sb01, CardIdentifier.SB01);
            }
        } else {
            AskToMeetRequirementProcess rp = new AskToMeetRequirementProcess(new IsSpecificCardRequirement("SB01"));
            rp.decide();
            Deck d = rp.getResult();
            if(d != null){
                this.result = new LogicCard(d, CardIdentifier.SB01);
            }
        }
    }

    public LogicCard getResult() {
        return result;
    }
}
