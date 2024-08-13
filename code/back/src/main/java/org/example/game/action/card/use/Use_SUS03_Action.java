package org.example.game.action.card.use;

import org.example.game.action.Action;
import org.example.game.action.card.play.Play_SB01_Action;
import org.example.game.action.card.require.Require_SB01_Action;
import org.example.game.board.card.logic.LogicCard;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.ArrayList;
import java.util.List;

public class Use_SUS03_Action extends Action {
    private LogicCard logicCard;
    private List<Role> targets;
    public Use_SUS03_Action(Role subject, LogicCard card, List<Role> targets) {
        super("Use_SUS03_Action", subject);
        this.logicCard = card;
        this.targets = new ArrayList<>(targets);
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("Use_SUS03_Action:使用一张【决斗】\n");
        for(Role currentTarget: this.targets){
            if(!this.subject.getHero().condition.alive){
                Logger.printf("决斗期间死亡，提前结束\n");
                return;
            }
            while(true){
                boolean targetPlay = this.requireSB01(currentTarget);
                if(!targetPlay){
                    new InflictAction(this.subject, currentTarget, 1).process(this);
                    break;
                }
                boolean subjectPlay = this.requireSB01(this.subject);
                if(!subjectPlay){
                    new InflictAction(currentTarget, this.subject, 1).process(this);
                    break;
                }
            }
        }
        new MoveToDiscardDeckAction(this.subject, this.logicCard.getPhysicalCard()).process(this);
    }


    private boolean requireSB01(Role target){
        Require_SB01_Action requireAction = new Require_SB01_Action(target);
        requireAction.process(this);
        LogicCard result = requireAction.getRequireResult();
        if(result != null){
            new Play_SB01_Action(target, result).process(this);
            return true;
        } else {
            return false;
        }
    }
}
