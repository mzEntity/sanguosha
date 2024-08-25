package org.example.game.board.card.concrete;

import org.example.game.board.card.Card;
import org.example.game.board.card.CardIdentifier;
import org.example.game.board.card.Suit;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class DefaultCard extends Card {
    public DefaultCard(Suit suit, int point) {
        super(suit, point, CardIdentifier.DEFAULT);
    }
}
