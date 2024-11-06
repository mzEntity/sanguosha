package org.example.game.logic.action.card;

import org.example.game.board.card.deck.Deck;
import org.example.game.logic.Action;
import org.example.game.role.Role;
import org.example.view.Logger;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class MoveToHandAreaAction extends Action {
    private final Role subject;
    private final Deck deck;

    public MoveToHandAreaAction(Role subject, Deck deck) {
        super();
        this.subject = subject;
        this.deck = deck;
    }

    @Override
    protected void mainLogic(Action from) {
        if(this.deck.size() <= 0){
            System.err.println("置入手牌的牌少于一张");
            return;
        }
        Logger.log("%s进入%s的手牌区\n", this.deck.toStringInLine(), this.subject);
        Deck handDeck = this.subject.getHandDeck();
        this.deck.moveAllToBack(handDeck);
    }
}
