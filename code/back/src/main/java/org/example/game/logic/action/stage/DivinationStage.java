package org.example.game.logic.action.stage;

import org.example.game.board.area.player.DivinationArea;
import org.example.game.board.card.concrete.skill.DelayedSkillCard;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.role.Role;
import org.example.game.logic.Action;
import org.example.log.Logger;

public class DivinationStage extends Action {
    private Role subject;
    public DivinationStage(Role subject) {
        super();
        this.subject = subject;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("DivinationStage:判定阶段\n");
        DivinationArea area = subject.getPlayerArea().getDivinationArea();
        LogicCard task = null;
        task = area.getNextTask();
        while(task != null) {
            DelayedSkillCard card = (DelayedSkillCard)task.getLogicCard();
            Logger.printf("%s进行判定任务：%s\n", this.subject.code, card.getType());
            area.finishTask(card.getType());
            task = area.getNextTask();
        }
    }
}
