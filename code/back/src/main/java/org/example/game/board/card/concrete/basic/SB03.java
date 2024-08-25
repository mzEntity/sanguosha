package org.example.game.board.card.concrete.basic;

import org.example.game.board.card.Card;
import org.example.game.board.card.CardIdentifier;
import org.example.game.board.card.Suit;
import org.example.game.board.card.concrete.BasicCard;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class SB03 extends BasicCard {
    public SB03(Suit suit, int point) {
        super(suit, point, CardIdentifier.SB03);
    }
}
