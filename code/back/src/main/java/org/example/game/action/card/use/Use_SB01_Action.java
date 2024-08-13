package org.example.game.action.card.use;

import org.example.game.action.Action;
import org.example.game.action.TriggerTable;
import org.example.game.action.card.play.Play_SB02_Action;
import org.example.game.action.card.require.Require_SB02_Action;
import org.example.game.action.card.target.Specified_SB01_Action;
import org.example.game.action.card.target.Target_SB01_Action;
import org.example.game.board.card.logic.LogicCard;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.ArrayList;
import java.util.List;

// 使用【杀】
public class Use_SB01_Action extends Action{
    private List<Role> targets;
    private LogicCard logicCard;

    public Use_SB01_Action(Role subject, LogicCard card, List<Role> targets) {
        super("Use_SB01_Action", subject);
        this.logicCard = card;
        this.targets = new ArrayList<>(targets);
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("Use_SB01_Action:使用一张【杀】\n");
        Target_SB01_Action targetAction = new Target_SB01_Action(this.subject, this.targets);
        targetAction.process(this);
        List<Role> finalTargets = targetAction.getTargets();
        for(int i = 0; i < finalTargets.size(); i++) {
            Role target = finalTargets.get(i);
            Specified_SB01_Action specifiedAction = new Specified_SB01_Action(target);
            specifiedAction.process(this);


            LogicCard result = requireAction.getRequireResult();
            if(result == null){
                new InflictAction(this.subject, target, 1).process(this);
            } else {
                new Play_SB02_Action(target, result).process(this);
            }
        }

        new MoveToDiscardDeckAction(this.subject, this.logicCard.getPhysicalCard());
    }

}
