package org.example.game.filter.subfilter;

import org.example.game.Game;
import org.example.game.filter.TargetFilter;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.ArrayList;
import java.util.List;

public class AttackRangeFilter implements TargetFilter {
    @Override
    public List<Role> filterTargets(Role subject, List<Role> targets) {
        Game game = Game.getGame();
        List<Role> allRoles = game.roles;
        List<Role> availableTargets = new ArrayList<>();
        int subjectIndex = allRoles.indexOf(subject);
        for(Role role: targets){
            int targetIndex = allRoles.indexOf(role);
            int distance = game.distance.get(subjectIndex).get(targetIndex);
            if(distance > subject.attackRange){
                continue;
            }
            availableTargets.add(role);
        }
        return availableTargets;
    }
}
