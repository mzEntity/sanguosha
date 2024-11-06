package org.example.game.logic.action.divination;

import org.example.game.board.card.Card;
import org.example.game.board.card.deck.Deck;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.global.SelectFromDrawAreaAction;
import org.example.game.requirement.CardRequirement;
import org.example.game.role.Role;
import org.example.view.Logger;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class DivinationAction extends Action {
    private final Role subject;
    private Deck result;

    public DivinationAction(Role subject) {
        this.subject = subject;
        this.result = null;
    }

    @Override
    protected void mainLogic(Action from) {
        SelectFromDrawAreaAction s = new SelectFromDrawAreaAction(1);
        s.process(this);
        this.result = s.getSelectResult();
        Logger.log("%s的判定结果为%s\n", this.subject, this.result.toStringInLine());
    }

    public boolean isMet(CardRequirement c){
        Card card = this.result.getCard(0);
        LogicCard l = new LogicCard(this.result, card.getCid());
        return c.isMet(l);
    }

    public Deck getResult() {
        return result;
    }
}
