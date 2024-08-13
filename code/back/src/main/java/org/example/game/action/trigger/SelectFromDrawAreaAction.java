package org.example.game.action.trigger;

import org.example.game.Game;
import org.example.game.action.Action;
import org.example.game.board.card.Deck;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class SelectFromDrawAreaAction extends Action {
    private int selectCount;
    private Deck selectResult;

    public SelectFromDrawAreaAction(Role subject, int selectCount) {
        super(subject);
        this.selectCount = selectCount;
        this.selectResult = new Deck();
    }

    @Override
    protected void mainLogic(Action from) {
        Deck drawDeck = Game.getDrawDeck();
        if(drawDeck.size() < selectCount) {
            new ReshuffleAction().process(this);
        }
        if(drawDeck.size() < selectCount) {
            new GameOverAction("牌堆不足，游戏结束");
        }
        this.selectResult = drawDeck.selectSomeAsDeck(0, this.selectCount);
    }

    public Deck getSelectResult() {
        return this.selectResult;
    }
}
