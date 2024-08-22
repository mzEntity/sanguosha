package org.example.game.board.card.logic;

import org.example.game.logic.Action;
import org.example.game.board.card.Card;
import org.example.game.board.card.Deck;
import org.example.game.role.Role;

import java.util.List;

public class LogicCard {
    private Deck physicalCard;
    private Card logicCard;

    public LogicCard(Deck physicalCard, Card logicCard) {
        this.physicalCard = physicalCard;
        this.logicCard = logicCard;
    }

    public LogicCard(Deck physicalCard) {
        this.physicalCard = physicalCard;
        this.logicCard = null;
    }

    public Deck getPhysicalCard() {
        return physicalCard;
    }

    public Card getLogicCard() {
        return logicCard;
    }

    public String getId(){
        return this.logicCard.id;
    }
}
