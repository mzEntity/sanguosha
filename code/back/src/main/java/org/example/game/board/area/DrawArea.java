package org.example.game.board.area;

import org.example.game.board.card.deck.Deck;

public class DrawArea {
    private final Deck deck;

    public DrawArea(Deck deck) {
        this.deck = deck;
    }

    public Deck getDeck() {
        return deck;
    }
}
