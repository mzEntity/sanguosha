package org.example.game.requirement;

import org.example.game.board.card.deck.LogicCard;

public class DefaultRequirement extends CardRequirement {

    public DefaultRequirement() {
        super();
    }

    @Override
    public boolean isMet(LogicCard lc) {
        return true;
    }
}
