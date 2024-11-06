package org.example.game.logic.action.card;

import org.example.game.logic.Action;
import org.example.game.board.card.deck.Deck;
import org.example.game.role.Role;
import org.example.view.Logger;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class DiscardAction extends Action {
    private final Role subject;
    private final Deck discard;

    public DiscardAction(Role subject, Deck discard) {
        super();
        this.subject = subject;
        this.discard = discard;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.log("%s弃置了%s\n", this.subject, this.discard.toStringInLine());
        new MoveToDiscardAreaAction(this.discard).process(this);
    }

    public Role getSubject() {
        return subject;
    }

    public Deck getDiscard() {
        return discard;
    }
}
