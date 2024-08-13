package org.example.game.board.area;

import org.example.game.board.card.Deck;

public class DrawArea {
    public Deck available;

    public DrawArea(Deck deck) {
        this.available = deck;
    }
}
