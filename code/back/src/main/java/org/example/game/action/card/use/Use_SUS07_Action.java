package org.example.game.action.card.use;

import org.example.game.action.Action;
import org.example.game.board.card.logic.LogicCard;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.ArrayList;
import java.util.List;

public class Use_SUS07_Action extends Action {
    private List<Role> targets;
    private LogicCard logicCard;

    public Use_SUS07_Action(Role subject, LogicCard card, List<Role> targets) {
        super("Use_SUS07_Action", subject);
        this.logicCard = card;
        this.targets = new ArrayList<>(targets);
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("Use_SUS0y_Action:使用一张【无中生有】\n");

        for(Role target: this.targets){
            new DrawCardAction(target, 2).process(this);
        }
        new MoveToDiscardDeckAction(this.subject, this.logicCard.getPhysicalCard()).process(this);
    }
}
