package org.example.game.requirement;

import org.example.game.board.card.Deck;
import org.example.game.board.card.logic.LogicCard;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public abstract class CardRequirement {
    public String description;

    public CardRequirement(String description) {
        this.description = description;
    }

    public abstract boolean isMet(LogicCard lc);
}
