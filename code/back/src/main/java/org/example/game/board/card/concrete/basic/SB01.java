package org.example.game.board.card.concrete.basic;

import org.example.game.board.card.Card;
import org.example.game.board.card.CardIdentifier;
import org.example.game.board.card.Suit;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/22
 */
public class SB01 extends Card {
    public SB01(Suit suit, int point) {
        super(suit, point, CardIdentifier.SB01);
    }
}
