package org.example.game.logic.action.stage;

import org.example.game.logic.Turn;
import org.example.game.logic.action.card.DiscardAction;
import org.example.game.board.card.deck.Deck;
import org.example.game.role.Role;
import org.example.game.logic.Action;
import org.example.log.Logger;

public class DiscardingStage extends RoleStage {
    private final Turn turn;

    public DiscardingStage(Role subject, Turn turn) {
        super(subject);
        this.turn = turn;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("%s的弃牌阶段\n", this.subject);
        int handLimit = this.turn.handLimit;

        Deck handDeck = this.subject.getPlayerArea().getHandArea().cards;
        if(handDeck.size() > handLimit){
            int discardCount = handDeck.size() - handLimit;
            Logger.printf("手牌数(%d)超过手牌上限(%d),请弃牌%d张\n", handDeck.size(), handLimit, discardCount);
            Deck newDeck = handDeck.selectSomeAsDeck(0, discardCount);

            new DiscardAction(this.subject, newDeck).process(this);
        }
    }
}
