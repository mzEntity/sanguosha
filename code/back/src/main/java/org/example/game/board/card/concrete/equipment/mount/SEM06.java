package org.example.game.board.card.concrete.equipment.mount;

import org.example.game.board.card.Card;
import org.example.game.board.card.CardIdentifier;
import org.example.game.board.card.Suit;
import org.example.game.board.card.concrete.equipment.MountCard;

/**
 * @Description: 大宛
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class SEM06 extends MountCard {
    public SEM06(Suit suit, int point) {
        super(suit, point, CardIdentifier.SEM06, MountType.March);
    }
}
