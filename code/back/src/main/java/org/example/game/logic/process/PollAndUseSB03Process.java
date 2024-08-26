package org.example.game.logic.process;

import org.example.game.Game;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.LogicProcess;
import org.example.game.logic.action.require.RequireUseSB03Action;
import org.example.game.logic.action.use.UseSB03Action;
import org.example.game.role.Role;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/25
 */
public class PollAndUseSB03Process extends LogicProcess {
    private final Role target;
    private final int count;

    public PollAndUseSB03Process(Role target, int count) {
        this.target = target;
        this.count = count;
    }

    @Override
    public void process(Action from){
        int count = 0;
        List<Role> aliveRoles = Game.getAliveRoles();
        for(Role role : aliveRoles) {
            while(count < this.count){
                RequireUseSB03Action r = new RequireUseSB03Action(role, this.target);
                r.process(from);
                LogicCard result = r.getResult();
                if (result != null) {
                    UseSB03Action u = new UseSB03Action(role, new ArrayList<>(
                            Collections.singletonList(this.target)
                    ), result);
                    u.process(from);
                    count += 1;
                } else {
                    break;
                }
            }
            if(count == this.count){
                break;
            }
        }

    }
}
