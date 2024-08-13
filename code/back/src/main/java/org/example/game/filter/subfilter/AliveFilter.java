package org.example.game.filter.subfilter;

import org.example.game.filter.TargetFilter;
import org.example.game.role.Role;

import java.util.ArrayList;
import java.util.List;

public class AliveFilter implements TargetFilter {
    @Override
    public List<Role> filterTargets(Role subject, List<Role> targets) {
        List<Role> availableTargets = new ArrayList<>();
        for(Role r: targets){
            if(r.getHero().condition.alive){
                availableTargets.add(r);
            }
        }
        return availableTargets;
    }
}
