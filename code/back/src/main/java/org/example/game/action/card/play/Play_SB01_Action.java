package org.example.game.action.card.play;

import org.example.game.action.Action;
import org.example.game.board.card.logic.LogicCard;
import org.example.game.role.Role;
import org.example.log.Logger;

public class Play_SB01_Action extends Action {
    private LogicCard logicCard;
    public Play_SB01_Action(Role subject, LogicCard card) {
        super("Play_SB01_Action", subject);
        this.logicCard = card;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("Play_SB01_Action:打出一张杀\n");
        new MoveToDiscardDeckAction(this.subject, this.logicCard.getPhysicalCard()).process(this);
    }
}
