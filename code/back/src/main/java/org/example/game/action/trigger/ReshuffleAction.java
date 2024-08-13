package org.example.game.action.trigger;

import org.example.game.Game;
import org.example.game.action.Action;
import org.example.game.board.card.Deck;
import org.example.game.role.Role;
import org.example.log.Logger;

/**
 * @Description: 将弃牌堆的牌放入抽牌堆
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class ReshuffleAction extends Action {
    public ReshuffleAction() {
        super(null);
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("触发重新洗牌\n");
        Deck drawDeck = Game.getDrawDeck();
        Deck discardDeck = Game.getDiscardDeck();
        discardDeck.moveAllToBack(drawDeck);
    }
}
