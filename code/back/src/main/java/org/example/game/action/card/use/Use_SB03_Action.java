package org.example.game.action.card.use;

import org.example.game.action.Action;
import org.example.game.action.card.target.Target_SB03_Action;
import org.example.game.board.card.logic.LogicCard;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.ArrayList;
import java.util.List;

public class Use_SB03_Action extends Action {
    private List<Role> targets;
    private LogicCard logicCard;

    public Use_SB03_Action(Role subject, LogicCard card, List<Role> targets) {
        super("Use_SB03_Action", subject);
        this.logicCard = card;
        this.targets = new ArrayList<>(targets);
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("Use_SB02_Action:使用一张【闪】\n");
        Target_SB03_Action targetAction = new Target_SB03_Action(this.subject, this.targets);
        targetAction.process(this);
        List<Role> finalTargets = targetAction.getTargets();
        for(Role target: finalTargets){
            new RecuperationAction(this.subject, target, 1).process(this);
        }
        new MoveToDiscardDeckAction(this.subject, this.logicCard.getPhysicalCard()).process(this);
    }
}
