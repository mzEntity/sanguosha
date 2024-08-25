package org.example.game.filter.subfilter;

import org.example.game.filter.TargetFilter;
import org.example.game.role.Role;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/23
 */
public class SelfFilter implements TargetFilter {
    @Override
    public List<Role> filterTargets(Role subject, List<Role> targets) {
        if(targets.contains(subject)){
            return new ArrayList<>(Collections.singletonList(subject));
        }
        return new ArrayList<>();
    }
}
