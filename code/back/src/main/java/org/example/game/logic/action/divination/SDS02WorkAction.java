package org.example.game.logic.action.divination;

import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.stage.Turn;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.requirement.RequirementTable;
import org.example.game.role.Role;
import org.example.view.Logger;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class SDS02WorkAction extends Action {
    private final LogicCard targetSDS02;
    private final Role subject;
    private final DivinationAction divination;

    public SDS02WorkAction(Role subject, LogicCard targetSDS02, DivinationAction divination) {
        super();
        this.subject = subject;
        this.targetSDS02 = targetSDS02;
        this.divination = divination;
    }

    @Override
    protected void mainLogic(Action from) {
        if(this.divination != null){
            if(this.divination.isMet(RequirementTable.getRequirement("SDS02"))){
                Logger.log("%s的[乐不思蜀]生效\n", this.subject);
                Turn turn = this.subject.getCurrentTurn();
                turn.getPunchingStage().setSkipped(true);
            } else {
                Logger.log("%s的[乐不思蜀]失效\n", this.subject);
            }
            new MoveToDiscardAreaAction(divination.getResult()).process(this);
        } else {
            Logger.log("%s的[乐不思蜀]失效\n", this.subject);
        }
        new MoveToDiscardAreaAction(this.targetSDS02.getDeck()).process(this);

    }

    public Role getSubject() {
        return subject;
    }

    public LogicCard getTarget() {
        return targetSDS02;
    }

    public DivinationAction getDivination() {
        return divination;
    }
}
