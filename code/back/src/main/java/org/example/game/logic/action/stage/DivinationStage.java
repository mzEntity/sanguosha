package org.example.game.logic.action.stage;

import org.example.game.board.area.player.DivinationArea;
import org.example.game.board.card.concrete.skill.DelayedSkillCard;
import org.example.game.board.card.concrete.skill.delayed.DelayedSkillType;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.LogicProcess;
import org.example.game.logic.process.SDS01DivinationProcess;
import org.example.game.logic.process.SDS02DivinationProcess;
import org.example.game.role.Role;
import org.example.game.logic.Action;

import java.util.HashMap;
import java.util.function.BiFunction;

public class DivinationStage extends RoleStage {

    private static final HashMap<DelayedSkillType, BiFunction<Role, LogicCard, LogicProcess>> divinationMap;

    static {
        divinationMap = new HashMap<>();
        divinationMap.put(DelayedSkillType.SDS01, (role, lc) -> new SDS01DivinationProcess(role, lc));
        divinationMap.put(DelayedSkillType.SDS02, (role, lc) -> new SDS02DivinationProcess(role, lc));
    }

    public DivinationStage(Role subject) {
        super(subject);
    }

    @Override
    protected void mainLogic(Action from) {
        DivinationArea area = this.subject.getPlayerArea().getDivinationArea();
        LogicCard task = null;
        task = area.getNextTask();
        while(task != null) {
            DelayedSkillCard card = (DelayedSkillCard)task.getLogicRepresentation();
            DelayedSkillType type = card.getType();
            divinationMap.get(type).apply(this.subject, task).process(this);
            area.finishTask(card.getType());
            task = area.getNextTask();
        }
    }
}
