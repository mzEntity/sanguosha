package org.example.game.action.process;

import org.example.game.action.Action;
import org.example.game.action.TriggerIdentifier;
import org.example.game.action.TriggerTable;
import org.example.game.board.card.logic.LogicCard;
import org.example.game.role.Role;

import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/12
 */
public class PlayProcess extends Action{
    private LogicCard logicCard;

    public PlayProcess(Role subject, LogicCard logicCard) {
        super("PLAY" + logicCard.getId(), subject);
        this.logicCard = logicCard;
    }

    @Override
    protected void mainLogic(Action from) {
    }
}
