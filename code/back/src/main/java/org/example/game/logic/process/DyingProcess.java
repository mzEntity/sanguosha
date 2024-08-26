package org.example.game.logic.process;

import org.example.game.Game;
import org.example.game.logic.Action;
import org.example.game.logic.LogicProcess;
import org.example.game.logic.action.global.GameOverAction;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.board.area.player.PlayerArea;
import org.example.game.logic.action.role.DeadAction;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class DyingProcess extends LogicProcess {
    private final Role subject;
    public DyingProcess(Role subject) {
        super();
        this.subject = subject;
    }

    @Override
    public void process(Action from) {
        int need = 1 - this.subject.condition.hp;
        PollAndUseSB03Process p = new PollAndUseSB03Process(this.subject, need);
        p.process(from);
        boolean isDead = this.subject.isDying();
        if(isDead){
            new DeadAction(this.subject).process(from);
        }
    }


}
