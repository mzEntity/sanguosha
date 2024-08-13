package org.example.game.board.card.logic;

import org.example.game.board.card.Card;
import org.example.game.board.card.Deck;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/12
 */
public class SB01 extends LogicCard {
    public SB01(Deck physicalCard, Card logicCard) {
        super(physicalCard, logicCard);
    }

    @Override
    public void process(Role subject, List<Role> targets) {

    }
}
