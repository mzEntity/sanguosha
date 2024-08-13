package org.example.game.filter;

import org.example.game.role.Role;

import java.util.ArrayList;
import java.util.List;

public class DefaultFilter implements TargetFilter{
    @Override
    public List<Role> filterTargets(Role subject, List<Role> targets) {
        return new ArrayList<>(targets);
    }
}
