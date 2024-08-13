package org.example.game.requirement;

import org.example.game.Game;
import org.example.game.board.card.Deck;
import org.example.game.board.card.logic.LogicCard;
import org.example.game.role.Role;

import java.util.HashMap;
import java.util.List;

public class RequirementTable {
    private static final HashMap<String, CardRequirement> requirementTable = new HashMap<>();

    public RequirementTable() {
    }

    public static void setRequirement(String requirementCode, CardRequirement requirement){
        requirementTable.put(requirementCode, requirement);
    }

    public static boolean isMetRequirement(LogicCard lc, String requirementCode){
        return getRequirement(requirementCode).isMet(lc);
    }

    public static CardRequirement getRequirement(String requirementCode){
        if(!requirementTable.containsKey(requirementCode)){
            return new DefaultRequirement();
        }
        return requirementTable.get(requirementCode);
    }

}