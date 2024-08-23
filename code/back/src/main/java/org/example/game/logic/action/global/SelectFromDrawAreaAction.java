package org.example.game.logic.action.global;

import org.example.game.Game;
import org.example.game.logic.Action;
import org.example.game.board.card.deck.Deck;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class SelectFromDrawAreaAction extends Action {
    private int selectCount;
    private Deck selectResult;

    public SelectFromDrawAreaAction(int selectCount) {
        super();
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
            new GameOverAction("牌堆不足，游戏结束").process(this);
        }
        this.selectResult = drawDeck.selectSomeAsDeck(0, this.selectCount);
    }

    public Deck getSelectResult() {
        return this.selectResult;
    }
}
