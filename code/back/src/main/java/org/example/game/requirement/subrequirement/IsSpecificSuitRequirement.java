package org.example.game.requirement.subrequirement;

import org.example.game.board.card.Suit;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.requirement.CardRequirement;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class IsSpecificSuitRequirement extends CardRequirement {
    private Suit suit;

    public IsSpecificSuitRequirement(Suit suit) {
        this.suit = suit;
    }

    @Override
    public boolean isMet(LogicCard lc) {
        Suit lcSuit = lc.getLogicCard().suit;
        return lcSuit == suit;
    }
}
