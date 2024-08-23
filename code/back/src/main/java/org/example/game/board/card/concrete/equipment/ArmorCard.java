package org.example.game.board.card.concrete.equipment;

import org.example.game.board.card.CardIdentifier;
import org.example.game.board.card.Suit;
import org.example.game.board.card.concrete.EquipmentCard;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class ArmorCard extends EquipmentCard {
    public ArmorCard(Suit suit, int point, CardIdentifier cid) {
        super(suit, point, cid);
    }
}
