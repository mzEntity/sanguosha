package org.example.game.logic.action.use;

import org.example.game.board.card.deck.Deck;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToWeaponAreaAction;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class UseWeaponAction extends Action {

    private final Role subject;
    private final Deck target;

    public UseWeaponAction(Role subject, Deck target) {
        super();
        this.subject = subject;
        this.target = target;
    }

    @Override
    protected void mainLogic(Action from) {
        new MoveToWeaponAreaAction(this.subject, this.target).process(this);
    }

    public Role getSubject() {
        return subject;
    }

    public Deck getTarget() {
        return target;
    }
}
