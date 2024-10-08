package org.example.game.board.card.concrete.basic;

import org.example.game.board.card.Card;
import org.example.game.board.card.CardIdentifier;
import org.example.game.board.card.Suit;
import org.example.game.board.card.concrete.BasicCard;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/22
 */
public class SB02 extends BasicCard {
    public SB02(Suit suit, int point) {
        super(suit, point, CardIdentifier.SB02);
    }
}
