package org.example.game.board.area;

import org.example.game.board.card.deck.Deck;

public class DiscardArea {
    private Deck deck;

    public DiscardArea(Deck deck) {
        this.deck = deck;
    }

    public Deck getDeck() {
        return deck;
    }
}
