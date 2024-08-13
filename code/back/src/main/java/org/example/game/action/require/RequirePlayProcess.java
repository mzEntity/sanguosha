package org.example.game.action.require;

import org.example.game.action.Action;
import org.example.game.role.Role;
import org.example.game.requirement.CardRequirement;

/**
 * @Description: 询问打出牌
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class RequirePlayProcess extends Action {
    private CardRequirement requirement;

    public RequirePlayProcess(Role subject, CardRequirement requirement) {
        super(subject);
        this.requirement = requirement;
    }

    @Override
    protected void mainLogic(Action from) {

    }
}
