package org.example.game.logic.action.use;

import org.example.game.board.card.deck.Deck;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToArmorAreaAction;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class UseArmorAction extends Action {
    private final Role subject;
    private final Deck target;

    public UseArmorAction(Role subject, Deck target) {
        super();
        this.subject = subject;
        this.target = target;
    }

    @Override
    protected void mainLogic(Action from) {
        new MoveToArmorAreaAction(this.subject, this.target).process(this);
    }
}
