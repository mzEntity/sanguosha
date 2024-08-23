package org.example.game.board.card;

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
        return this.logicCard.cid.getId();
    }
}
