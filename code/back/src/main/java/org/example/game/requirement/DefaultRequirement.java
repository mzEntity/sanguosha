package org.example.game.requirement;

import org.example.game.board.card.Deck;
import org.example.game.board.card.logic.LogicCard;
import org.example.game.role.Role;

import java.util.ArrayList;
import java.util.List;

public class DefaultRequirement extends CardRequirement {

    public DefaultRequirement() {
        super("default");
    }

    @Override
    public boolean isMet(LogicCard lc) {
        return true;
    }
}
