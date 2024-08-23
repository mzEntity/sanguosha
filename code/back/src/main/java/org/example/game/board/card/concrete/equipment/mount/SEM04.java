package org.example.game.board.card.concrete.equipment.mount;

import org.example.game.board.card.Card;
import org.example.game.board.card.CardIdentifier;
import org.example.game.board.card.Suit;
import org.example.game.board.card.concrete.equipment.MountCard;

/**
 * @Description: 赤兔
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class SEM04 extends MountCard {
    public SEM04(Suit suit, int point) {
        super(suit, point, CardIdentifier.SEM04, MountType.March);
    }
}
