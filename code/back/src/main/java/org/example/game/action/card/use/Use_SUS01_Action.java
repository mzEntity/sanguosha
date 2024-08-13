package org.example.game.action.card.use;

import org.example.game.Game;
import org.example.game.action.Action;
import org.example.game.board.card.logic.LogicCard;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.List;

public class Use_SUS01_Action extends Action {
    private LogicCard logicCard;
    public Use_SUS01_Action(Role subject, LogicCard card) {
        super("Use_SUS01_Action", subject);
        this.logicCard = card;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("Use_SUS01_Action:使用一张【桃园结义】\n");
        Game game = Game.getGame();
        List<Role> targets = game.roles;
        int index = targets.indexOf(game.activeRole);
        for(int i = 0; i < targets.size(); i++){
            int currentIndex = (i + index) % targets.size();
            Role currentTarget = targets.get(currentIndex);
            if(!currentTarget.getHero().condition.alive){
                continue;
            }
            if(currentTarget.getHero().condition.isHurt()){
                new RecuperationAction(this.subject, currentTarget, 1).process(this);
            }
        }
        new MoveToDiscardDeckAction(this.subject, this.logicCard.getPhysicalCard()).process(this);
    }
}
