package org.example.game.action.trigger;

import org.example.game.action.Action;
import org.example.game.board.card.Deck;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class DiscardAction extends Action {
    private Deck discard;

    public DiscardAction(Role subject, Deck discard) {
        super(subject);
        this.discard = discard;
    }

    @Override
    protected void mainLogic(Action from) {
        new MoveToDiscardAreaAction(this.subject, this.discard).process(this);
    }
}
