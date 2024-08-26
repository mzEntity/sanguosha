package org.example.game.logic.process;

import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.LogicProcess;
import org.example.game.logic.action.divination.DivinationAction;
import org.example.game.logic.action.divination.SDS02WorkAction;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/26
 */
public class SDS02DivinationProcess extends LogicProcess {
    private Role subject;
    private LogicCard targetSDS02;

    public SDS02DivinationProcess(Role subject, LogicCard targetSDS02) {
        this.subject = subject;
        this.targetSDS02 = targetSDS02;
    }

    @Override
    public void process(Action from) {
        PollAndUseSUS09Process p = new PollAndUseSUS09Process(this.targetSDS02);
        p.process(from);
        DivinationAction divination = null;
        if(p.getResult() == null){
            divination = new DivinationAction(this.subject);
            divination.process(from);
        }
        new SDS02WorkAction(this.subject, this.targetSDS02, divination).process(from);
    }
}
