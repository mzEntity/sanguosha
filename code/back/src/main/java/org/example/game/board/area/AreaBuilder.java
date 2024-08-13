package org.example.game.board.area;

import org.example.game.board.card.Deck;
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
            Deck divinationDeck = new Deck();
            DivinationArea divinationArea = new DivinationArea(divinationDeck);

            Deck weaponDeck = new Deck();
            Deck armorDeck = new Deck();
            Deck retreatMountDeck = new Deck();
            Deck marchMountDeck = new Deck();
            EquipmentArea equipmentArea = new EquipmentArea(weaponDeck, armorDeck, retreatMountDeck, marchMountDeck);

            Deck handDeck = new Deck();
            HandArea handArea = new HandArea(handDeck);
            PlayerArea playerArea = new PlayerArea(divinationArea, equipmentArea, handArea);

            playerAreaList.add(playerArea);
        }

        Deck drawDeck = new Deck();
        DrawArea drawArea = new DrawArea(drawDeck);

        Deck discardDeck = new Deck();
        DiscardArea discardArea = new DiscardArea(discardDeck);

        return new Area(playerAreaList, drawArea, discardArea);
    }
}
