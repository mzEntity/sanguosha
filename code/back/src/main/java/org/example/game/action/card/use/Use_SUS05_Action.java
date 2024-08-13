package org.example.game.action.card.use;

import org.example.game.Game;
import org.example.game.action.Action;
import org.example.game.board.card.Deck;
import org.example.game.board.card.logic.LogicCard;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.List;

public class Use_SUS05_Action extends Action {
    private LogicCard logicCard;
    public Use_SUS05_Action(Role subject, LogicCard card) {
        super("Use_SUS05_Action", subject);
        this.logicCard = card;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("Use_SUS05_Action:使用一张【五谷丰登】\n");
        Game game = Game.getGame();
        List<Role> targets = game.roles;
        int deckSize = game.getAliveRoleCount();
        Deck drawDeck = game.board.area.drawArea.available;
        if(deckSize > drawDeck.size()){
            new InitDrawDeckAction().process(this);
        }
        Deck targetDeck = drawDeck.selectSomeAsDeck(0, deckSize);

        int index = targets.indexOf(game.activeRole);
        for(int i = 0; i < targets.size(); i++){
            int currentIndex = (i + index) % targets.size();
            Role currentTarget = targets.get(currentIndex);
            if(!currentTarget.getHero().condition.alive){
                continue;
            }
            SelectAction selectAction = new SelectAction(currentTarget, targetDeck, 1);
            selectAction.process(this);
            Deck getCard = selectAction.getSelectResult();
            Logger.printf("%s\n", getCard);
            getCard.moveAllToBack(currentTarget.playerArea.handArea.cards);
        }
        new MoveToDiscardDeckAction(null, targetDeck).process(this);
        new MoveToDiscardDeckAction(this.subject, this.logicCard.getPhysicalCard()).process(this);
    }
}
