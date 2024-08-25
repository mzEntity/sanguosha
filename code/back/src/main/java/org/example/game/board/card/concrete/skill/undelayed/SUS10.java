package org.example.game.board.card.concrete.skill.undelayed;

import org.example.game.board.card.Card;
import org.example.game.board.card.CardIdentifier;
import org.example.game.board.card.Suit;

/**
 * @Description: 借刀杀人
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class SUS10 extends Card {
    public SUS10(Suit suit, int point) {
        super(suit, point, CardIdentifier.SUS10);
    }
}
