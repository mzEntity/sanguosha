package org.example.game.logic.action.card;

import org.example.game.logic.Action;
import org.example.game.board.card.deck.Deck;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class DiscardAction extends Action {
    private Role subject;
    private Deck discard;

    public DiscardAction(Role subject, Deck discard) {
        super();
        this.subject = subject;
        this.discard = discard;
    }

    @Override
    protected void mainLogic(Action from) {
        new MoveToDiscardAreaAction(this.discard).process(this);
    }
}
