package org.example.game.logic.action.card;

import org.example.game.board.area.player.DivinationArea;
import org.example.game.board.card.Card;
import org.example.game.board.card.concrete.skill.DelayedSkillCard;
import org.example.game.board.card.concrete.skill.delayed.DelayedSkillType;
import org.example.game.board.card.deck.Deck;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class MoveToDivinationAreaAction extends Action {
    private Role subject;
    private LogicCard target;

    public MoveToDivinationAreaAction(Role subject, LogicCard lc) {
        super();
        this.subject = subject;
        this.target = lc;
    }

    @Override
    protected void mainLogic(Action from) {
        Deck d = this.target.getPhysicalCard();
        if(d.size() != 1){
            System.err.println("延时锦囊只能用一张牌表示");
        }
        DelayedSkillCard c = (DelayedSkillCard) this.target.getLogicCard();
        DelayedSkillType type = c.getType();
        DivinationArea area = this.subject.getPlayerArea().getDivinationArea();
        area.addTask(type, this.target);
    }
}
