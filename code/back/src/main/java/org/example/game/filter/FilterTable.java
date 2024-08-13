package org.example.game.filter;

import java.util.HashMap;

public class FilterTable {
    private static HashMap<String, TargetFilter> filterTable = new HashMap<>();


    public FilterTable() {
    }

    public static void setFilter(String cardCode, TargetFilter targetFilter){
        filterTable.put(cardCode, targetFilter);
    }

    public static TargetFilter getFilter(String cardCode){
        if(!filterTable.containsKey(cardCode)){
            return filterTable.get("Default");
        }
        return filterTable.get(cardCode);
    }

}
