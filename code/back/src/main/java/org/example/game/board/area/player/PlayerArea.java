package org.example.game.board.area.player;

import org.example.game.board.area.player.DivinationArea;
import org.example.game.board.area.player.EquipmentArea;

public class PlayerArea {
    public DivinationArea divinationArea;
    public EquipmentArea equipmentArea;
    public HandArea handArea;

    public PlayerArea(DivinationArea divinationArea, EquipmentArea equipmentArea, HandArea handArea) {
        this.divinationArea = divinationArea;
        this.equipmentArea = equipmentArea;
        this.handArea = handArea;
    }
}
