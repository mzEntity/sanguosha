package org.example.game.filter;

import org.example.game.role.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class NotFilter implements TargetFilter{
    private TargetFilter filter;

    public NotFilter(TargetFilter filter) {
        this.filter = filter;
    }

    @Override
    public List<Role> filterTargets(Role subject, List<Role> targets) {
        List<Role> filterResult = this.filter.filterTargets(subject, targets);
        List<Role> result = new ArrayList<>();
        for(Role role : targets){
            if(!filterResult.contains(role)){
                result.add(role);
            }
        }
        return result;
    }
}
