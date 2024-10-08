package org.example.game.filter.subfilter;

import org.example.game.distance.AttackRangeTable;
import org.example.game.filter.TargetFilter;
import org.example.game.role.Role;

import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/14
 */
public class DistanceWithinAttackRangeFilter implements TargetFilter {
    @Override
    public List<Role> filterTargets(Role subject, List<Role> targets) {
        int attackRange = AttackRangeTable.getAttackRange(subject);
        return new WithinDistanceFilter(attackRange).filterTargets(subject, targets);
    }
}
