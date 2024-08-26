package org.example.game.board.area.player.equipment;

import org.example.game.board.card.deck.Deck;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class MountArea {
    private final Deck deck;

    public MountArea(Deck deck) {
        this.deck = deck;
    }

    public Deck getDeck(){
        return this.deck;
    }

    public boolean isEmpty(){
        return this.deck.isEmpty();
    }
}
