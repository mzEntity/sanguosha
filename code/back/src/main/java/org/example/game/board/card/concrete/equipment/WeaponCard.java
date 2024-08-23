package org.example.game.board.card.concrete.equipment;

import org.example.game.board.card.CardIdentifier;
import org.example.game.board.card.Suit;
import org.example.game.board.card.concrete.EquipmentCard;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class WeaponCard extends EquipmentCard {
    private int attackRange;
    public WeaponCard(Suit suit, int point, CardIdentifier cid, int attackRange) {
        super(suit, point, cid);
        this.attackRange = attackRange;
    }

    public int getAttackRange() {
        return attackRange;
    }
}
