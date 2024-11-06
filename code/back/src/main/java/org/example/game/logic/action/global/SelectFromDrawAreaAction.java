package org.example.game.logic.action.global;

import org.example.game.Game;
import org.example.game.logic.Action;
import org.example.game.board.card.deck.Deck;
import org.example.view.Logger;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class SelectFromDrawAreaAction extends Action {
    private final int selectCount;
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
            new GameOverAction("牌堆不足").process(this);
        }
        this.selectResult = drawDeck.selectSomeAsDeck(0, this.selectCount);
        Logger.log("牌堆顶的%d张牌为%s\n", this.selectCount, this.selectResult.toStringInLine());
    }

    public Deck getSelectResult() {
        return this.selectResult;
    }
}
