package org.example.game.board.card.concrete;

import org.example.game.board.card.Card;
import org.example.game.board.card.CardIdentifier;
import org.example.game.board.card.Suit;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class BasicCard extends Card {
    public BasicCard(Suit suit, int point, CardIdentifier cid) {
        super(suit, point, cid);
    }
}
