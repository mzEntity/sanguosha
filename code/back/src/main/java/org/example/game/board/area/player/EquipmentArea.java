package org.example.game.board.area.player;

import org.example.game.board.area.player.equipment.ArmorArea;
import org.example.game.board.area.player.equipment.MountArea;
import org.example.game.board.area.player.equipment.WeaponArea;
import org.example.game.board.card.deck.Deck;

public class EquipmentArea {
    private final WeaponArea weaponArea;
    private final ArmorArea armorArea;
    private final MountArea retreatMountArea;
    private final MountArea marchMountArea;

    public EquipmentArea(WeaponArea weaponArea, ArmorArea armorArea, MountArea retreatMountArea, MountArea marchMountArea) {
        this.weaponArea = weaponArea;
        this.armorArea = armorArea;
        this.retreatMountArea = retreatMountArea;
        this.marchMountArea = marchMountArea;
    }

    public Deck getAllEquipments(){
        Deck newDeck = new Deck();
        this.weaponArea.getDeck().moveAllToBack(newDeck);
        this.armorArea.getDeck().moveAllToBack(newDeck);
        this.retreatMountArea.getDeck().moveAllToBack(newDeck);
        this.marchMountArea.getDeck().moveAllToBack(newDeck);
        return newDeck;
    }

    public WeaponArea getWeaponArea() {
        return weaponArea;
    }

    public ArmorArea getArmorArea() {
        return armorArea;
    }

    public MountArea getRetreatMountArea() {
        return retreatMountArea;
    }

    public MountArea getMarchMountArea() {
        return marchMountArea;
    }
}
