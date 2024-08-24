package org.example.game.filter.subfilter;

import org.example.game.filter.TargetFilter;
import org.example.game.role.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class InjuredFilter implements TargetFilter {
    @Override
    public List<Role> filterTargets(Role subject, List<Role> targets) {
        List<Role> availableTargets = new ArrayList<>();
        for(Role r: targets){
            if(!subject.isFullBlood()){
                availableTargets.add(r);
            }
        }
        return availableTargets;
    }
}
