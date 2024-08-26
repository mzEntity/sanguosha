package org.example.game.board.area;

import org.example.game.board.card.deck.Deck;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/25
 */
public class ProcessArea {
    private final Deck deck;

    public ProcessArea(Deck deck) {
        this.deck = deck;
    }

    public Deck getDeck() {
        return deck;
    }
}
