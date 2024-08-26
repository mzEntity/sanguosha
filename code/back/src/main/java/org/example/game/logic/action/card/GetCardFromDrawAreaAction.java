package org.example.game.logic.action.card;

import org.example.game.logic.Action;
import org.example.game.board.card.deck.Deck;
import org.example.game.logic.action.global.SelectFromDrawAreaAction;
import org.example.game.role.Role;

/**
 * @Description: 摸牌
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class GetCardFromDrawAreaAction extends Action {
    private final Role subject;
    private final Deck deck;

    public GetCardFromDrawAreaAction(Role subject, Deck deck) {
        super();
        this.subject = subject;
        this.deck = deck;
    }

    @Override
    protected void mainLogic(Action from) {
        new MoveToHandAreaAction(this.subject, this.deck).process(this);
    }

    public Role getSubject() {
        return subject;
    }

    public Deck getDeck() {
        return deck;
    }
}
