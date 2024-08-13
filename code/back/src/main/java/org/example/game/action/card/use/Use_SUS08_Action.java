package org.example.game.action.card.use;

import org.example.game.Game;
import org.example.game.action.Action;
import org.example.game.action.card.play.Play_SB01_Action;
import org.example.game.action.card.require.Require_SB01_Action;
import org.example.game.board.card.logic.LogicCard;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.List;

public class Use_SUS08_Action extends Action {
    private LogicCard logicCard;
    public Use_SUS08_Action(Role subject, LogicCard card) {
        super("Use_SUS08_Action", subject);
        this.logicCard = card;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("Use_SUS08_Action:使用一张【南蛮入侵】\n");
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
            Require_SB01_Action requireAction = new Require_SB01_Action(currentTarget);
            requireAction.process(this);
            LogicCard result = requireAction.getRequireResult();
            if(result == null){
                new InflictAction(this.subject, currentTarget, 1).process(this);
            } else {
                new Play_SB01_Action(currentTarget, result).process(this);
            }
        }
        new MoveToDiscardDeckAction(this.subject, this.logicCard.getPhysicalCard()).process(this);
    }
}
