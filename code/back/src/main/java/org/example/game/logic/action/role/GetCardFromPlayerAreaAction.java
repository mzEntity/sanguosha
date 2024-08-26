package org.example.game.logic.action.role;

import org.example.game.board.card.deck.Deck;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToHandAreaAction;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class GetCardFromPlayerAreaAction extends Action {
    private final Role by;
    private final Role to;
    private final Deck deck;

    public GetCardFromPlayerAreaAction(Role subject, Role target, Deck deck) {
        super();
        this.by = subject;
        this.to = target;
        this.deck = deck;
    }

    @Override
    protected void mainLogic(Action from) {
        new MoveToHandAreaAction(this.by, this.deck).process(this);
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
