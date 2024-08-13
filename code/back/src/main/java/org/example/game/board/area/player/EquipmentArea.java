package org.example.game.board.area.player;

import org.example.game.board.card.Deck;

public class EquipmentArea {
    private Deck weapon;
    private Deck armor;
    private Deck retreatMount;
    private Deck marchMount;

    public EquipmentArea(Deck weapon, Deck armor, Deck retreatMount, Deck marchMount) {
        this.weapon = weapon;
        this.armor = armor;
        this.retreatMount = retreatMount;
        this.marchMount = marchMount;
    }
}
