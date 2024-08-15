package org.example.game.filter.subfilter;

import org.example.game.distance.DistanceTable;
import org.example.game.filter.TargetFilter;
import org.example.game.role.Role;
import org.example.log.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/14
 */
public class WithinDistanceFilter implements TargetFilter {
    private int within;

    public WithinDistanceFilter(int within) {
        this.within = within;
    }

    @Override
    public List<Role> filterTargets(Role subject, List<Role> targets) {
        List<Role> availableTargets = new ArrayList<>();
        for(Role r: targets){
            int distance = DistanceTable.getDistance(subject, r);
            if(distance <= this.within && distance >= 0){
                availableTargets.add(r);
            }
        }
        return availableTargets;
    }
}
