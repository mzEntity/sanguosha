package org.example.game.filter.subfilter;

import org.example.game.filter.CompositeOrFilter;
import org.example.game.filter.TargetFilter;
import org.example.game.role.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class WithEquipmentCardFilter implements TargetFilter {
    @Override
    public List<Role> filterTargets(Role subject, List<Role> targets) {
        return new CompositeOrFilter(new ArrayList<>(
                Arrays.asList(
                        new WithWeaponCardFilter(),
                        new WithArmorCardFilter(),
                        new WithMountCardFilter()
                )
        )).filterTargets(subject, targets);
    }
}
