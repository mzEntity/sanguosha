package org.example.game.requirement.subrequirement;


import org.example.game.board.card.logic.LogicCard;
import org.example.game.requirement.CardRequirement;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class IsSpecificCardRequirement extends CardRequirement {
    private String cardId;

    public IsSpecificCardRequirement(String cardId) {
        super();
        this.cardId = cardId;
    }

    @Override
    public boolean isMet(LogicCard lc) {
        return this.cardId.equals(lc.getLogicCard().id);
    }
}
