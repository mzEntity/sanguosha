package org.example.game.logic.action.card;

import org.example.game.Game;
import org.example.game.logic.Action;
import org.example.game.board.card.deck.Deck;
import org.example.view.Logger;

/**
 * @Description: 将牌置入弃牌堆中
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class MoveToDiscardAreaAction extends Action {
    private final Deck targetDeck;

    public MoveToDiscardAreaAction(Deck deck) {
        super();
        this.targetDeck = deck;
    }

    @Override
    protected void mainLogic(Action from) {
        if(this.targetDeck.size() <= 0){
            System.err.println("弃掉的牌少于1张");
            return;
        }
        Logger.log("%s进入弃牌区\n", this.targetDeck.toStringInLine());

        Deck discardAreaDeck = Game.getDiscardDeck();
        this.targetDeck.moveAllToBack(discardAreaDeck);
    }
}
