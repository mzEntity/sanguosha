package org.example.game.logic.action.global;

import org.example.game.Game;
import org.example.game.logic.Action;
import org.example.game.board.card.deck.Deck;
import org.example.view.Logger;

/**
 * @Description: 将弃牌堆的牌放入抽牌堆
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class ReshuffleAction extends Action {
    public ReshuffleAction() {
        super();
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.log("牌堆不足，重新洗牌\n");
        Deck drawDeck = Game.getDrawDeck();
        Deck discardDeck = Game.getDiscardDeck();
        discardDeck.moveAllToBack(drawDeck);
        drawDeck.shuffle();
    }
}
