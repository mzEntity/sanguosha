package org.example.game.filter.card;

import org.example.game.filter.TargetFilter;
import org.example.game.filter.subfilter.AliveFilter;
import org.example.game.filter.subfilter.AttackRangeFilter;
import org.example.game.filter.subfilter.NotSelfFilter;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.ArrayList;
import java.util.List;

public class SB01_TargetFilter implements TargetFilter {
    private List<TargetFilter> filters;

    public SB01_TargetFilter() {
        this.filters = new ArrayList<>();
        filters.add(new NotSelfFilter());
        filters.add(new AliveFilter());
        filters.add(new AttackRangeFilter());
    }

    @Override
    public List<Role> filterTargets(Role subject, List<Role> targets) {
        List<Role> finalTargets = targets;
        for(TargetFilter filter: this.filters){
            finalTargets = filter.filterTargets(subject, finalTargets);
        }
        return finalTargets;
    }
}
