package org.example.game.logic.action.global;

import org.example.game.logic.Action;

/**
 * @Description: 游戏结束
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class GameOverAction extends Action {

    private final String msg;

    public GameOverAction(String msg) {
        super();
        this.msg = msg;
    }

    @Override
    protected void mainLogic(Action from) {
        System.exit(0);
    }

    public String getMsg() {
        return msg;
    }
}
