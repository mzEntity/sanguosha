package org.example.game.logic.action.card;

import org.example.game.logic.Action;
import org.example.game.board.card.deck.Deck;
import org.example.game.logic.action.global.SelectFromDrawAreaAction;
import org.example.game.role.Role;
import org.example.log.Logger;

/**
 * @Description: 摸牌
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class DrawCardAction extends Action {
    private final Role subject;
    private final int drawCount;

    public DrawCardAction(Role subject, int drawCount) {
        super();
        this.subject = subject;
        this.drawCount = drawCount;
    }

    @Override
    protected void mainLogic(Action from) {
        SelectFromDrawAreaAction sa = new SelectFromDrawAreaAction(this.drawCount);
        sa.process(this);
        Deck selected = sa.getSelectResult();
        Logger.printf("%s从牌堆中摸牌%s\n", this.subject, selected);
        new MoveToHandAreaAction(this.subject, selected).process(this);
    }
}
