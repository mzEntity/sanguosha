package org.example.game.requirement;

import org.example.game.board.card.deck.LogicCard;

import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class NotRequirement extends CardRequirement{
    private CardRequirement requirement;

    public NotRequirement(CardRequirement requirement) {
        super();
        this.requirement = requirement;
    }

    @Override
    public boolean isMet(LogicCard lc) {
        return !this.requirement.isMet(lc);
    }
}
