package org.example.game.logic.action.use;

import org.example.game.board.card.logic.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.action.require.RequireUseSB02Action;
import org.example.game.logic.action.role.InjurySettleAction;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/22
 */
public class UseSB02Action extends Action{
    private Role subject;
    private LogicCard targetSB01;
    private LogicCard logicCard;

    public UseSB02Action(Role subject, LogicCard targetSB01, LogicCard logicCard) {
        super();
        this.subject = subject;
        this.targetSB01 = targetSB01;
        this.logicCard = logicCard;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("%s使用一张[闪]\n", this.subject.code);
        new MoveToDiscardAreaAction(this.logicCard.getPhysicalCard()).process(this);
    }
}
