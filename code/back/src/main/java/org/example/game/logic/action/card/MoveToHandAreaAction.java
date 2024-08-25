package org.example.game.logic.action.card;

import org.example.game.Game;
import org.example.game.board.card.deck.Deck;
import org.example.game.logic.Action;
import org.example.game.role.Role;
import org.example.log.Logger;

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
            return;
        }
        Logger.printf("放入%s手牌区的牌：%s\n", this.subject, this.deck);
        Deck handDeck = this.subject.getHandDeck();
        this.deck.moveAllToBack(handDeck);
    }
}
