package org.example.game.action.trigger;

import org.example.game.action.Action;
import org.example.game.role.Role;
import org.example.log.Logger;

/**
 * @Description: 游戏结束
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class GameOverAction extends Action {

    private String msg;

    public GameOverAction(String msg) {
        super(null);
        this.msg = msg;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("GameOverAction: %s\n", this.msg);
        System.exit(0);
    }
}
