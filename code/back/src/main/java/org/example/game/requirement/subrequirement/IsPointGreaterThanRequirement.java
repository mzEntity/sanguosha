package org.example.game.requirement.subrequirement;

import org.example.game.board.card.deck.LogicCard;
import org.example.game.requirement.CardRequirement;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class IsPointGreaterThanRequirement extends CardRequirement {
    private int point;

    public IsPointGreaterThanRequirement(int point) {
        this.point = point;
    }

    @Override
    public boolean isMet(LogicCard lc) {
        return lc.getPoint() > this.point;
    }
}
