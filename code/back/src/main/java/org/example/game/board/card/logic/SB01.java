package org.example.game.board.card.logic;

import org.example.game.action.Action;
import org.example.game.action.process.InjurySettleProcess;
import org.example.game.board.card.Card;
import org.example.game.board.card.Deck;
import org.example.game.board.card.Suit;
import org.example.game.role.Role;

import java.util.List;

/**
 * @Description: 基本牌：杀
 * @Author: mzvltr
 * @Date: 2024/8/12
 */
public class SB01 extends LogicCard {
    public SB01(Deck physicalCard) {
        super(physicalCard, physicalCard.transform("SB01"));
    }

    @Override
    public void process(Action useProcess, Role subject, List<Role> targets) {
        for(Role target : targets) {
            new InjurySettleProcess(subject, target).process(useProcess);
        }
    }
}
