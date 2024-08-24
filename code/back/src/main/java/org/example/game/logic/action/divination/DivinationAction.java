package org.example.game.logic.action.divination;

import org.example.game.board.card.deck.Deck;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.global.SelectFromDrawAreaAction;
import org.example.game.requirement.CardRequirement;
import org.example.game.role.Role;
import org.example.log.Logger;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class DivinationAction extends Action {
    private Role subject;
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
        Logger.printf("判定结果为：%s\n", this.result);
    }

    public boolean isMet(CardRequirement c){
        LogicCard l = new LogicCard(this.result, this.result.getCard(0));
        return c.isMet(l);
    }

    public Deck getResult() {
        return result;
    }
}
