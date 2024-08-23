package org.example.game.board.area;

import org.example.game.board.area.player.equipment.ArmorArea;
import org.example.game.board.area.player.equipment.MountArea;
import org.example.game.board.area.player.equipment.WeaponArea;
import org.example.game.board.card.deck.Deck;
import org.example.game.board.area.player.DivinationArea;
import org.example.game.board.area.player.EquipmentArea;
import org.example.game.board.area.player.HandArea;
import org.example.game.board.area.player.PlayerArea;

import java.util.ArrayList;
import java.util.List;

public class AreaBuilder {
    public AreaBuilder() {
    }

    public Area buildArea(int playerCount){
        List<PlayerArea> playerAreaList = new ArrayList<>();
        for(int i = 0; i < playerCount; i++){
            PlayerArea playerArea = this.buildPlayerArea();
            playerAreaList.add(playerArea);
        }

        // 摸牌区
        Deck drawDeck = new Deck();
        DrawArea drawArea = new DrawArea(drawDeck);

        // 弃牌区
        Deck discardDeck = new Deck();
        DiscardArea discardArea = new DiscardArea(discardDeck);

        return new Area(playerAreaList, drawArea, discardArea);
    }

    public PlayerArea buildPlayerArea(){
        // 判定区
        Deck divinationDeck = new Deck();
        DivinationArea divinationArea = new DivinationArea(divinationDeck);

        // 装备区
        Deck weaponDeck = new Deck();
        Deck armorDeck = new Deck();
        Deck retreatMountDeck = new Deck();
        Deck marchMountDeck = new Deck();
        WeaponArea weaponArea = new WeaponArea(weaponDeck);
        ArmorArea armorArea = new ArmorArea(armorDeck);
        MountArea retreatMountArea = new MountArea(retreatMountDeck);
        MountArea marchMountArea = new MountArea(marchMountDeck);
        EquipmentArea equipmentArea = new EquipmentArea(weaponArea, armorArea, retreatMountArea, marchMountArea);

        // 手牌区
        Deck handDeck = new Deck();
        HandArea handArea = new HandArea(handDeck);

        // 角色区域
        return new PlayerArea(divinationArea, equipmentArea, handArea);
    }
}
