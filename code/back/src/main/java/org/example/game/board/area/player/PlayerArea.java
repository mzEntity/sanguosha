package org.example.game.board.area.player;

import org.example.game.board.area.player.DivinationArea;
import org.example.game.board.area.player.EquipmentArea;
import org.example.game.board.area.player.equipment.ArmorArea;
import org.example.game.board.area.player.equipment.MountArea;
import org.example.game.board.area.player.equipment.WeaponArea;

public class PlayerArea {
    private final DivinationArea divinationArea;
    private final EquipmentArea equipmentArea;
    private final HandArea handArea;

    public PlayerArea(DivinationArea divinationArea, EquipmentArea equipmentArea, HandArea handArea) {
        this.divinationArea = divinationArea;
        this.equipmentArea = equipmentArea;
        this.handArea = handArea;
    }

    public DivinationArea getDivinationArea() {
        return divinationArea;
    }

    public EquipmentArea getEquipmentArea() {
        return equipmentArea;
    }

    public WeaponArea getWeaponArea(){
        return equipmentArea.getWeaponArea();
    }

    public ArmorArea getArmorArea(){
        return equipmentArea.getArmorArea();
    }

    public MountArea getRetreatMountArea() {
        return equipmentArea.getRetreatMountArea();
    }

    public MountArea getMarchMountArea() {
        return equipmentArea.getMarchMountArea();
    }

    public HandArea getHandArea() {
        return handArea;
    }
}
