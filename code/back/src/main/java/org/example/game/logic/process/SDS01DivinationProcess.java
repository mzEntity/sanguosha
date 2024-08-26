package org.example.game.logic.process;

import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.LogicProcess;
import org.example.game.logic.action.divination.DivinationAction;
import org.example.game.logic.action.divination.SDS01WorkAction;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/26
 */
public class SDS01DivinationProcess extends LogicProcess {
    private Role subject;
    private LogicCard targetSDS01;

    public SDS01DivinationProcess(Role subject, LogicCard targetSDS01) {
        this.subject = subject;
        this.targetSDS01 = targetSDS01;
    }

    @Override
    public void process(Action from) {
        PollAndUseSUS09Process p = new PollAndUseSUS09Process(this.targetSDS01);
        p.process(from);
        DivinationAction divination = null;
        if(p.getResult() == null){
            divination = new DivinationAction(this.subject);
            divination.process(from);
        }
        new SDS01WorkAction(this.subject, this.targetSDS01, divination).process(from);
    }
}
