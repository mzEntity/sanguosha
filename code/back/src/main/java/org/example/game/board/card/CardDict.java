package org.example.game.board.card;

import org.example.tools.FileOperator;

import java.util.HashMap;
import java.util.List;

public class CardDict {
    private static HashMap<String, String> cardDict = new HashMap<>();

    static {
        List<String> lines = FileOperator.readFile("./src/main/resources/cards.txt");
        for(String line: lines){
            String[] arr = line.split(" ");
            cardDict.put(arr[0], arr[1]);
        }
    }


    public static String getCardName(String cardId){
        if(!cardDict.containsKey(cardId)){
            return null;
        }
        return cardDict.get(cardId);
    }
}
