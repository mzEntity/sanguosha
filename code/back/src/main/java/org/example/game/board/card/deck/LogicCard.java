package org.example.game.board.card.deck;

import org.example.game.board.card.Card;
import org.example.game.board.card.CardBuilder;
import org.example.game.board.card.CardIdentifier;
import org.example.game.board.card.Suit;

public class LogicCard {
    private final Deck deck;
    private final Card logicRepresentation;

    public LogicCard(Deck deck, Suit suit, int point, CardIdentifier cid) {
        this.deck = deck;
        this.logicRepresentation = CardBuilder.buildCard(suit, point, cid);
    }

    public LogicCard(Deck physicalCard, CardIdentifier cid) {
        this.deck = physicalCard;
        Suit suit = physicalCard.getSuitOfDeck();
        int point = physicalCard.getPointOfDeck();
        this.logicRepresentation = CardBuilder.buildCard(suit, point, cid);
    }

    public LogicCard(Deck physicalCard) {
        this.deck = physicalCard;
        Suit suit = physicalCard.getSuitOfDeck();
        int point = physicalCard.getPointOfDeck();
        CardIdentifier cid = CardIdentifier.DEFAULT;
        this.logicRepresentation = CardBuilder.buildCard(suit, point, cid);
    }

    public Deck getDeck(){
        return this.deck;
    }

    public Suit getSuit() {
        return this.logicRepresentation.getSuit();
    }

    public int getPoint() {
        return this.logicRepresentation.getPoint();
    }

    public CardIdentifier getCid() {
        return this.logicRepresentation.getCid();
    }

    public Card getLogicRepresentation() {
        return logicRepresentation;
    }
}
