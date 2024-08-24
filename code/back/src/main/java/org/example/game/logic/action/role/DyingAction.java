package org.example.game.logic.action.role;

import org.example.game.Game;
import org.example.game.logic.Action;
import org.example.game.logic.action.global.GameOverAction;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.board.area.player.PlayerArea;
import org.example.game.role.Role;
import org.example.log.Logger;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class DyingAction extends Action {
    private Role subject;
    public DyingAction(Role subject) {
        super();
        this.subject = subject;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("%s进入濒死\n", this.subject.code);
        boolean isDead = this.subject.isDying();
        if(isDead){
            Logger.printf("玩家%s死亡\n", this.subject.code);
            this.subject.die();
            if(Game.getGame().noMoreThanOneLeft()){
                new GameOverAction("仅剩一人及以下存活，游戏结束").process(this);
            }
            this.clearArea();
        }
    }

    private void clearArea(){
        PlayerArea area = this.subject.getPlayerArea();
        new MoveToDiscardAreaAction(area.getHandArea().cards).process(this);
        new MoveToDiscardAreaAction(area.getEquipmentArea().getAllEquipments()).process(this);
        new MoveToDiscardAreaAction(area.getDivinationArea().combineDeck()).process(this);
    }
}
