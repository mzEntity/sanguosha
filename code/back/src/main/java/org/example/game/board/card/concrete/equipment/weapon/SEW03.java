package org.example.game.board.card.concrete.equipment.weapon;

import org.example.game.board.card.Card;
import org.example.game.board.card.CardIdentifier;
import org.example.game.board.card.Suit;
import org.example.game.board.card.concrete.equipment.WeaponCard;

/**
 * @Description: 青钢剑
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class SEW03 extends WeaponCard {
    public SEW03(Suit suit, int point) {
        super(suit, point, CardIdentifier.SEW03, 2);
    }
}
