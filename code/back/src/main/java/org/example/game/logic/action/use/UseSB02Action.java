package org.example.game.logic.action.use;

import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.role.Role;
import org.example.log.Logger;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/22
 */
public class UseSB02Action extends Action{
    private final Role subject;
    private final LogicCard targetSB01;
    private final LogicCard logicCard;

    public UseSB02Action(Role subject, LogicCard targetSB01, LogicCard logicCard) {
        super();
        this.subject = subject;
        this.targetSB01 = targetSB01;
        this.logicCard = logicCard;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("%s使用一张[闪]\n", this.subject);
        new MoveToDiscardAreaAction(this.logicCard.getDeck()).process(this);
    }
}
