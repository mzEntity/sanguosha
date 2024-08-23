package org.example.game.filter;

import org.example.game.role.Role;

import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/13
 */
public class CompositeAndFilter implements TargetFilter {
    private List<TargetFilter> filters;

    public CompositeAndFilter(List<TargetFilter> filters) {
        this.filters = filters;
    }

    @Override
    public List<Role> filterTargets(Role subject, List<Role> targets) {
        List<Role> result = targets;
        for(TargetFilter filter : filters) {
            result = filter.filterTargets(subject, result);
        }
        return result;
    }
}
