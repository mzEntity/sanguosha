package org.example.game.filter;

import org.example.game.role.Role;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class CompositeOrFilter implements TargetFilter{
    private List<TargetFilter> filters;

    public CompositeOrFilter(List<TargetFilter> filters) {
        this.filters = filters;
    }

    @Override
    public List<Role> filterTargets(Role subject, List<Role> targets) {
        List<HashSet<Role>> resultList = new ArrayList<>();
        for(TargetFilter filter : filters) {
            List<Role> curResult = filter.filterTargets(subject, targets);
            resultList.add(new HashSet<>(curResult));
        }
        HashSet<Role> finalResult = new HashSet<>();
        for(HashSet<Role> curResult : resultList) {
            finalResult.addAll(curResult);
        }

        List<Role> result = new ArrayList<>();
        for(Role target : targets) {
            if(finalResult.contains(target)) {
                result.add(target);
            }
        }
        return result;
    }
}
