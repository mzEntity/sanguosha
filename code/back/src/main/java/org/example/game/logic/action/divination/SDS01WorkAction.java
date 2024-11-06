package org.example.game.logic.action.divination;

import org.example.game.Game;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.action.card.MoveToDivinationAreaAction;
import org.example.game.logic.action.role.InjurySettleAction;
import org.example.game.requirement.RequirementTable;
import org.example.game.role.Role;
import org.example.view.Logger;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class SDS01WorkAction extends Action{
    private final Role subject;
    private final LogicCard targetSDS01;
    private final DivinationAction divination;

    public SDS01WorkAction(Role subject, LogicCard targetSDS01, DivinationAction divination) {
        super();
        this.subject = subject;
        this.targetSDS01 = targetSDS01;
        this.divination = divination;
    }

    @Override
    public void mainLogic(Action from) {
        if(this.divination == null){
            Logger.log("%s的[闪电]失效\n", this.subject);
            new MoveToDivinationAreaAction(Game.getAliveNext(this.subject), this.targetSDS01).process(this);
        } else {
            if(this.divination.isMet(RequirementTable.getRequirement("SDS01"))){
                Logger.log("%s的[闪电]生效\n", this.subject);
                new InjurySettleAction(null, this.subject, 3).process(this);
                new MoveToDiscardAreaAction(divination.getResult()).process(this);
                new MoveToDiscardAreaAction(this.targetSDS01.getDeck()).process(this);
            } else {
                Logger.log("%s的[闪电]失效\n", this.subject);
                new MoveToDiscardAreaAction(divination.getResult()).process(this);
                new MoveToDivinationAreaAction(Game.getAliveNext(this.subject), this.targetSDS01).process(this);
            }
        }
    }

    public Role getSubject() {
        return subject;
    }

    public LogicCard getTarget() {
        return targetSDS01;
    }

    public DivinationAction getDivination() {
        return divination;
    }


}
