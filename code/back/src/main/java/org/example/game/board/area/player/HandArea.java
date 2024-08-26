package org.example.game.board.area.player;

import org.example.game.board.card.deck.Deck;

public class HandArea {
    private final Deck deck;

    public HandArea(Deck deck) {
        this.deck = deck;
    }

    public Deck getDeck() {
        return deck;
    }
}
