package org.example.game.logic.process;

import org.example.game.board.card.deck.Deck;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.GetCardFromDrawAreaAction;
import org.example.game.logic.action.card.MoveToHandAreaAction;
import org.example.game.logic.action.global.SelectFromDrawAreaAction;
import org.example.game.role.Role;
import org.example.game.logic.LogicProcess;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/26
 */
public class DrawCardProcess extends LogicProcess {
    private final Role subject;
    private final int drawCount;

    public DrawCardProcess(Role subject, int drawCount) {
        super();
        this.subject = subject;
        this.drawCount = drawCount;
    }

    public void process(Action from) {
        SelectFromDrawAreaAction sa = new SelectFromDrawAreaAction(this.drawCount);
        sa.process(from);
        Deck selected = sa.getSelectResult();
        new GetCardFromDrawAreaAction(this.subject, selected).process(from);
    }
}
