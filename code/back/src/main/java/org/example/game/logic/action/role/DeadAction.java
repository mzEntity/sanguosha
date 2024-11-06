package org.example.game.logic.action.role;

import org.example.game.Game;
import org.example.game.board.area.player.PlayerArea;
import org.example.game.logic.Action;
import org.example.game.logic.action.card.MoveToDiscardAreaAction;
import org.example.game.logic.action.global.GameOverAction;
import org.example.game.role.Role;
import org.example.view.Logger;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/26
 */
public class DeadAction extends Action {
    private Role subject;

    public DeadAction(Role subject) {
        super();
        this.subject = subject;
    }

    @Override
    protected void mainLogic(Action from) {
        this.subject.die();
        Logger.log("%s死亡\n", this.subject);
        if(Game.getGame().noMoreThanOneLeft()){
            new GameOverAction("仅剩一人及以下存活").process(this);
        }
        this.clearArea();
    }

    private void clearArea(){
        PlayerArea area = this.subject.getPlayerArea();
        new MoveToDiscardAreaAction(area.getHandArea().getDeck()).process(this);
        new MoveToDiscardAreaAction(area.getEquipmentArea().getAllEquipments()).process(this);
        new MoveToDiscardAreaAction(area.getDivinationArea().combineDeck()).process(this);
    }

    public Role getSubject() {
        return subject;
    }
}
