package org.example.game.logic.action.card;

import org.example.game.logic.Action;
import org.example.game.board.card.Deck;
import org.example.game.logic.action.global.SelectFromDrawAreaAction;
import org.example.game.role.Role;
import org.example.log.Logger;

/**
 * @Description: 摸牌
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class DrawCardAction extends Action {
    private Role subject;
    private int drawCount;

    public DrawCardAction(Role subject, int drawCount) {
        super();
        this.subject = subject;
        this.drawCount = drawCount;
    }

    @Override
    protected void mainLogic(Action from) {
        Deck handDeck = this.subject.getHandDeck();
        SelectFromDrawAreaAction sa = new SelectFromDrawAreaAction(this.drawCount);
        sa.process(this);
        Deck selected = sa.getSelectResult();
        Logger.printf("%s从摸牌堆摸牌：%s\n", this.subject.code, selected);
        selected.moveAllToBack(handDeck);
    }
}
