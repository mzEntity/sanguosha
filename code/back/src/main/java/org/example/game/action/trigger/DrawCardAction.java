package org.example.game.action.trigger;

import org.example.game.Game;
import org.example.game.action.Action;
import org.example.game.board.card.Deck;
import org.example.game.role.Role;
import org.example.log.Logger;

/**
 * @Description: 摸牌
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class DrawCardAction extends Action {
    private int drawCount;

    public DrawCardAction(Role subject, int drawCount) {
        super(subject);
        this.drawCount = drawCount;
    }

    @Override
    protected void mainLogic(Action from) {
        Deck handDeck = this.subject.getHandDeck();
        SelectFromDrawAreaAction sa = new SelectFromDrawAreaAction(this.subject, this.drawCount);
        sa.process(this);
        Deck selected = sa.getSelectResult();
        Logger.printf("从摸牌堆摸牌：%s\n", selected);
        selected.moveAllToBack(handDeck);
    }
}
