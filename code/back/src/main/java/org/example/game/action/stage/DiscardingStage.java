package org.example.game.action.stage;

import org.example.game.action.TriggerIdentifier;
import org.example.game.action.TriggerTable;
import org.example.game.action.Turn;
import org.example.game.action.trigger.DiscardAction;
import org.example.game.board.card.Deck;
import org.example.game.role.Role;
import org.example.game.action.Action;
import org.example.log.Logger;

public class DiscardingStage extends Action {
    private final Turn turn;

    public DiscardingStage(Role subject, Turn turn) {
        super(subject);
        this.turn = turn;
    }

    @Override
    protected void mainLogic(Action from) {
        Logger.printf("DiscardingStage:弃牌阶段\n");
        int handLimit = this.turn.handLimit;

        Deck handDeck = this.subject.playerArea.handArea.cards;
        if(handDeck.size() > handLimit){
            int discardCount = handDeck.size() - handLimit;
            Logger.printf("手牌数(%d)超过手牌上限(%d),请弃牌%d张\n", handDeck.size(), handLimit, discardCount);
            Deck newDeck = handDeck.selectSomeAsDeck(0, discardCount);

            new DiscardAction(this.subject, newDeck).process(this);
        }
    }
}
