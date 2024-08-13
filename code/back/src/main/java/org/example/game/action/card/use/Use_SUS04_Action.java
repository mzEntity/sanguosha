package org.example.game.action.card.use;

import org.example.game.action.Action;
import org.example.game.board.card.Deck;
import org.example.game.board.card.logic.LogicCard;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.ArrayList;
import java.util.List;

public class Use_SUS04_Action extends Action {
    private LogicCard logicCard;
    private List<Role> targets;
    public Use_SUS04_Action(Role subject, LogicCard card, List<Role> targets) {
        super("Use_SUS04_Action", subject);
        this.logicCard = card;
        this.targets = new ArrayList<>(targets);
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("Use_SUS04_Action:使用一张【顺手牵羊】\n");
        for(Role currentTarget: this.targets){
            Deck targetHandDeck = currentTarget.playerArea.handArea.cards;
            SelectAction selectAction = new SelectAction(this.subject, targetHandDeck, 1);
            selectAction.process(this);
            Deck selectDeck = selectAction.getSelectResult();
            Logger.printf("%s\n", selectDeck);
            selectDeck.moveAllToFront(this.subject.playerArea.handArea.cards);
        }
        new MoveToDiscardDeckAction(this.subject, this.logicCard.getPhysicalCard()).process(this);
    }

}
