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
    private Role subject;
    private Deck targetDeck;

    public MoveToHandAreaAction(Role subject, Deck deck) {
        super();
        this.subject = subject;
        this.targetDeck = deck;
    }

    @Override
    protected void mainLogic(Action from) {
        if(this.targetDeck.size() <= 0){
            return;
        }
        Logger.printf("放入手牌区的牌：%s\n", this.targetDeck);
        Deck handDeck = this.subject.getHandDeck();
        this.targetDeck.moveAllToBack(handDeck);
    }
}
