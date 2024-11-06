package org.example.game.logic.action.role;

import org.example.game.logic.Action;
import org.example.game.logic.trigger.TriggerBuilder;
import org.example.game.logic.trigger.TriggerManager;
import org.example.game.role.Role;
import org.example.view.Logger;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class GainHealthAction extends Action {
    private final Role by;
    private final Role to;
    private final int hpBefore;
    private final int count;

    public GainHealthAction(Role subject, Role target, int count) {
        super();
        this.by = subject;
        this.to = target;
        this.hpBefore = this.to.condition.hp;
        this.count = count;
    }

    @Override
    protected void mainLogic(Action from) {
        if(this.to.getHpLost() < this.count){
            System.err.println("回复的血量超过体力上限，出错了");
            return;
        }
        Logger.log("%s令%s回复%d点体力\n", this.by, this.to, this.count);
        this.to.gainHp(this.count);
    }

    public Role getBy() {
        return by;
    }

    public Role getTo() {
        return to;
    }

    public int getCount() {
        return count;
    }

    public int getHpBefore() {
        return hpBefore;
    }
}
