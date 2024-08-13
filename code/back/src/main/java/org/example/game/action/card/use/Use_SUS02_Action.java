package org.example.game.action.card.use;

import org.example.game.Game;
import org.example.game.action.Action;
import org.example.game.action.card.play.Play_SB02_Action;
import org.example.game.action.card.require.Require_SB02_Action;
import org.example.game.board.card.logic.LogicCard;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.List;

public class Use_SUS02_Action extends Action {
    private LogicCard logicCard;
    public Use_SUS02_Action(Role subject, LogicCard card) {
        super("Use_SUS02_Action", subject);
        this.logicCard = card;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("Use_SUS02_Action:使用一张【万箭齐发】\n");
        Game game = Game.getGame();
        List<Role> targets = game.roles;
        int index = targets.indexOf(game.activeRole);
        for(int i = 0; i < targets.size(); i++){
            int currentIndex = (i + index) % targets.size();
            Role currentTarget = targets.get(currentIndex);
            if(!currentTarget.getHero().condition.alive){
                continue;
            }
            if(currentTarget == this.subject){
                continue;
            }
            Require_SB02_Action requireAction = new Require_SB02_Action(currentTarget);
            requireAction.process(this);
            LogicCard result = requireAction.getRequireResult();
            if(result == null){
                new InflictAction(this.subject, currentTarget, 1).process(this);
            } else {
                new Play_SB02_Action(currentTarget, result).process(this);
            }
        }
        new MoveToDiscardDeckAction(this.subject, this.logicCard.getPhysicalCard()).process(this);
    }
}
