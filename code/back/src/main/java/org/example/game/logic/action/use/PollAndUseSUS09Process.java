package org.example.game.logic.action.use;

import org.example.game.Game;
import org.example.game.board.card.deck.LogicCard;
import org.example.game.logic.Action;
import org.example.game.logic.action.require.RequireUseSUS09Action;
import org.example.game.logic.action.use.undelayed.UseSUS09Action;
import org.example.game.role.Role;

import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class PollAndUseSUS09Process {
    private final Action from;
    private final LogicCard target;

    private Role subject;
    private LogicCard result;

    public PollAndUseSUS09Process(Action from, LogicCard target) {
        this.from = from;
        this.target = target;
        this.subject = null;
        this.result = null;
    }

    public void process(){
        boolean finish = false;
        while(!finish){
            finish = true;
            List<Role> aliveRoles = Game.getAliveRoles();
            for(Role role : aliveRoles){
                RequireUseSUS09Action r = new RequireUseSUS09Action(role);
                r.process(this.from);
                LogicCard result = r.getResult();
                if(result != null){
                    UseSUS09Action u = new UseSUS09Action(role, this.target, result);
                    u.process(this.from);
                    if(u.isOffset()){
                       finish = false;
                    } else {
                        this.subject = role;
                        this.result = result;
                    }
                    break;
                }
            }
        }
    }

    public Role getSubject() {
        return subject;
    }

    public LogicCard getResult() {
        return result;
    }
}
