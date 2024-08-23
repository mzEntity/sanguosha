package org.example.game.requirement;

import org.example.game.board.card.LogicCard;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public abstract class CardRequirement {

    public CardRequirement() {
    }

    public abstract boolean isMet(LogicCard lc);
}
