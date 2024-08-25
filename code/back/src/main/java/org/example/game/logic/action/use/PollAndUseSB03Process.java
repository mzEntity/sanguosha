package org.example.game.logic.action.use;

import org.example.game.Game;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.require.RequireUseSB03Action;
import org.example.game.logic.action.require.RequireUseSUS09Action;
import org.example.game.logic.action.use.undelayed.UseSUS09Action;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/25
 */
public class PollAndUseSB03Process {
    private final Action from;
    private final Role target;
    private final int count;

    public PollAndUseSB03Process(Action from, Role target, int count) {
        this.from = from;
        this.target = target;
        this.count = count;
    }

    public void process(){
        int count = 0;
        List<Role> aliveRoles = Game.getAliveRoles();
        for(Role role : aliveRoles) {
            while(count < this.count){
                Logger.printf("%s向%s求%d个桃\n", this.target, role, this.count - count);
                RequireUseSB03Action r = new RequireUseSB03Action(role, this.target);
                r.process(this.from);
                LogicCard result = r.getResult();
                if (result != null) {
                    UseSB03Action u = new UseSB03Action(role, new ArrayList<>(
                            Collections.singletonList(this.target)
                    ), result);
                    u.process(this.from);
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
