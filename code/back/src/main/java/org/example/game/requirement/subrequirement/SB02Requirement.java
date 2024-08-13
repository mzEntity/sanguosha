package org.example.game.requirement.subrequirement;


import org.example.game.board.card.Deck;
import org.example.game.board.card.logic.LogicCard;
import org.example.game.requirement.CardRequirement;

import java.util.Objects;

/**
 * @Description: 要求是一张闪
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class SB02Requirement extends CardRequirement {

    public SB02Requirement(String description) {
        super(description);
    }

    @Override
    public boolean isMet(LogicCard lc) {
        return "SB02".equals(lc.getLogicCard().id);
    }
}
