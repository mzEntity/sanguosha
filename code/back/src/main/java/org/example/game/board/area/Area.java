package org.example.game.board.area;

import org.example.game.board.area.player.PlayerArea;

import java.util.List;

public class Area {
    public List<PlayerArea> playerAreas;
    public DrawArea drawArea;
    public DiscardArea discardArea;
    public ProcessArea processArea;

    public Area(List<PlayerArea> playerAreas, DrawArea drawArea, DiscardArea discardArea, ProcessArea processArea) {
        this.playerAreas = playerAreas;
        this.drawArea = drawArea;
        this.discardArea = discardArea;
        this.processArea = processArea;
    }
}
