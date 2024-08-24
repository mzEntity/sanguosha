package org.example.game.board.card.concrete.skill.delayed;

import org.example.game.board.card.Card;
import org.example.game.board.card.CardIdentifier;
import org.example.game.board.card.Suit;
import org.example.game.board.card.concrete.skill.DelayedSkillCard;

/**
 * @Description: 乐不思蜀
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class SDS02 extends DelayedSkillCard {
    public SDS02(Suit suit, int point) {
        super(suit, point, CardIdentifier.SDS02, DelayedSkillType.SDS02);
    }
}
