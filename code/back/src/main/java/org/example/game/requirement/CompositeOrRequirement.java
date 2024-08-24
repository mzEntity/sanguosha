package org.example.game.requirement;

import org.example.game.board.card.deck.LogicCard;

import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class CompositeOrRequirement extends CardRequirement{
    private List<CardRequirement> requirements;

    public CompositeOrRequirement(List<CardRequirement> requirements) {
        super();
        this.requirements = requirements;
    }

    @Override
    public boolean isMet(LogicCard lc) {
        for(CardRequirement requirement : requirements) {
            if(requirement.isMet(lc)) {
                return true;
            }
        }
        return false;
    }
}
