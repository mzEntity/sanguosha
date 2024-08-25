package org.example.game.logic.action.play;

import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.role.Role;
import org.example.log.Logger;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class PlaySB01Action extends Action {
    private final Role subject;
    private final LogicCard targetSB01;

    public PlaySB01Action(Role subject, LogicCard targetSB01) {
        super();
        this.subject = subject;
        this.targetSB01 = targetSB01;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("%s打出一张[杀]\n", this.subject);
        new MoveToDiscardAreaAction(this.targetSB01.getDeck()).process(this);
    }
}
