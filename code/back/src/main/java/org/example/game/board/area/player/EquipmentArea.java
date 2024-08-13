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

    public Deck getAllEquipments(){
        Deck newDeck = new Deck();
        this.weapon.moveAllToBack(newDeck);
        this.armor.moveAllToBack(newDeck);
        this.retreatMount.moveAllToBack(newDeck);
        this.marchMount.moveAllToBack(newDeck);
        return newDeck;
    }
}
