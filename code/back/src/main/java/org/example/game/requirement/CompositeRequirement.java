package org.example.game.requirement;

import org.example.game.board.card.LogicCard;

import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class CompositeRequirement extends CardRequirement {
    private List<CardRequirement> requirements;

    public CompositeRequirement(List<CardRequirement> requirements) {
        super();
        this.requirements = requirements;
    }

    @Override
    public boolean isMet(LogicCard lc) {
        for(CardRequirement requirement : requirements) {
            if(!requirement.isMet(lc)) {
                return false;
            }
        }
        return true;
    }
}
