package org.example.game.requirement.subrequirement;

import org.example.game.board.card.concrete.equipment.ArmorCard;
import org.example.game.board.card.concrete.equipment.WeaponCard;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.requirement.CardRequirement;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class IsArmorCardRequirement extends CardRequirement {
    @Override
    public boolean isMet(LogicCard lc) {
        return lc.getLogicCard() instanceof ArmorCard;
    }
}
