package org.example.game.board;

import org.example.game.board.area.Area;
import org.example.game.board.area.AreaBuilder;
import org.example.tools.FileOperator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoardBuilder {

    public BoardBuilder() {
    }

    public Board buildBoard(int playerCount){
        Area area = new AreaBuilder().buildArea(playerCount);
        return new Board(area);
    }
}
