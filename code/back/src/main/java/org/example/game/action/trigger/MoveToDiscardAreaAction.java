package org.example.game.action.trigger;

import org.example.game.Game;
import org.example.game.action.Action;
import org.example.game.board.card.Deck;
import org.example.game.role.Role;
import org.example.log.Logger;

/**
 * @Description: 将牌置入弃牌堆中
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class MoveToDiscardAreaAction extends Action {
    private Deck targetDeck;

    public MoveToDiscardAreaAction(Role subject, Deck deck) {
        super(subject);
        this.targetDeck = deck;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("置入弃牌堆的牌：%s", this.targetDeck);
        Deck discardAreaDeck = Game.getDiscardDeck();
        this.targetDeck.moveAllToBack(discardAreaDeck);
    }
}
