package org.example.game.board.card.concrete.skill;

import org.example.game.board.card.CardIdentifier;
import org.example.game.board.card.Suit;
import org.example.game.board.card.concrete.SkillCard;
import org.example.game.board.card.concrete.skill.delayed.DelayedSkillType;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class DelayedSkillCard extends SkillCard {
    private DelayedSkillType type;

    public DelayedSkillCard(Suit suit, int point, CardIdentifier cid, DelayedSkillType type) {
        super(suit, point, cid);
        this.type = type;
    }

    public DelayedSkillType getType() {
        return type;
    }
}
