package org.example.game.board.area.player;

import org.example.game.board.card.deck.Deck;

public class DivinationArea {
    public Deck tasks;

    public DivinationArea(Deck tasks) {
        this.tasks = tasks;
    }

    public boolean isEmpty(){
        return tasks.isEmpty();
    }
}
