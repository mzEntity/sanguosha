package org.example.game.filter.subfilter;

import org.example.game.filter.TargetFilter;
import org.example.game.role.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class WithArmorCardFilter implements TargetFilter {
    public List<Role> filterTargets(Role subject, List<Role> targets) {
        List<Role> result = new ArrayList<>();
        for (Role target : targets) {
            if(!target.getPlayerArea().getArmorArea().isEmpty()){
                result.add(target);
            }
        }
        return result;
    }
}
