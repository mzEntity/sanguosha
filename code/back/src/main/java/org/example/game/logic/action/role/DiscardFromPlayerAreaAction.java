package org.example.game.logic.action.role;

import org.example.game.board.card.deck.Deck;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.DiscardAction;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.action.card.MoveToHandAreaAction;
import org.example.game.role.Role;
import org.example.view.Logger;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class DiscardFromPlayerAreaAction extends Action {
    private final Role by;
    private final Role to;
    private final Deck deck;

    public DiscardFromPlayerAreaAction(Role subject, Role target, Deck deck) {
        super();
        this.by = subject;
        this.to = target;
        this.deck = deck;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.log("%s弃置%s%s\n", this.by, this.to, this.deck.toStringInLine());
        new DiscardAction(this.to, this.deck).process(this);
    }

    public Role getBy() {
        return by;
    }

    public Role getTo() {
        return to;
    }

    public Deck getDeck() {
        return deck;
    }
}
