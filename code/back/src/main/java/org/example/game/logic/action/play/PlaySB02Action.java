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
public class PlaySB02Action extends Action {
    private Role subject;
    private LogicCard logicCard;

    public PlaySB02Action(Role subject, LogicCard logicCard) {
        super();
        this.subject = subject;
        this.logicCard = logicCard;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("%s打出一张[闪]\n", this.subject.code);
        new MoveToDiscardAreaAction(this.logicCard.getPhysicalCard()).process(this);
    }
}
