package org.example.game.logic.action.stage;

import org.example.game.logic.action.card.DiscardAction;
import org.example.game.board.card.deck.Deck;
import org.example.game.role.Role;
import org.example.game.logic.Action;

public class DiscardingStage extends RoleStage {
    private final Turn turn;

    public DiscardingStage(Role subject, Turn turn) {
        super(subject);
        this.turn = turn;
    }

    @Override
    protected void mainLogic(Action from) {
        int handLimit = this.turn.handLimit;

        Deck handDeck = this.subject.getPlayerArea().getHandArea().getDeck();
        if(handDeck.size() > handLimit){
            int discardCount = handDeck.size() - handLimit;
            Deck newDeck = handDeck.selectSomeAsDeck(0, discardCount);
            new DiscardAction(this.subject, newDeck).process(this);
        }
    }
}
