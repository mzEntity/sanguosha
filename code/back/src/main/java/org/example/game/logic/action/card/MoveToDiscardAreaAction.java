package org.example.game.logic.action.card;

import org.example.game.Game;
import org.example.game.logic.Action;
import org.example.game.board.card.deck.Deck;
import org.example.log.Logger;

/**
 * @Description: 将牌置入弃牌堆中
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class MoveToDiscardAreaAction extends Action {
    private Deck targetDeck;

    public MoveToDiscardAreaAction(Deck deck) {
        super();
        this.targetDeck = deck;
    }

    @Override
    protected void mainLogic(Action from) {
        if(this.targetDeck.size() <= 0){
            return;
        }
        Logger.printf("置入弃牌堆的牌：%s\n", this.targetDeck);
        Deck discardAreaDeck = Game.getDiscardDeck();
        this.targetDeck.moveAllToBack(discardAreaDeck);
    }
}
