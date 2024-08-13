package org.example.game.filter;

import org.example.game.Game;
import org.example.game.role.Role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FilterTable {
    private static final HashMap<String, TargetFilter> filterTable = new HashMap<>();

    public FilterTable() {
    }

    public static void setFilter(String filterCode, TargetFilter targetFilter){
        filterTable.put(filterCode, targetFilter);
    }

    public static List<Role> getAvailableTargets(Role subject, String filterCode){
        List<Role> roles = Game.getRoles();
        return getFilter(filterCode).filterTargets(subject, roles);
    }

    public static TargetFilter getFilter(String filterCode){
        if(!filterTable.containsKey(filterCode)){
            return new DefaultFilter();
        }
        return filterTable.get(filterCode);
    }

}
