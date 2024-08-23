package org.example.game.logic.action.require;

import org.example.Main;
import org.example.game.board.card.deck.Deck;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.requirement.AskToMeetRequirementProcess;
import org.example.game.requirement.subrequirement.IsSpecificCardRequirement;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class RequirePlaySB01Action extends Action {
    private Role subject;
    private LogicCard result;

    public RequirePlaySB01Action(Role subject) {
        super();
        this.subject = subject;
        this.result = null;
    }

    @Override
    protected void mainLogic(Action from) {
        if(Main.SGS_DEBUG){
            Deck handDeck = this.subject.getHandDeck();
            Deck sb02 = handDeck.getCardDeckIfContain(new IsSpecificCardRequirement("SB01"));
            if(sb02 != null){
                this.result = new LogicCard(sb02, sb02.transform("SB01"));
            }
        } else {
            AskToMeetRequirementProcess rp = new AskToMeetRequirementProcess(new IsSpecificCardRequirement("SB01"));
            rp.decide();
            Deck d = rp.getResult();
            if(d != null){
                this.result = new LogicCard(d, d.transform("SB01"));
            }
        }
    }

    public LogicCard getResult() {
        return result;
    }
}
