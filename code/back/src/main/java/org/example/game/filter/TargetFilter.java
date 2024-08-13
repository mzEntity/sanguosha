package org.example.game.filter;

import org.example.game.role.Role;

import java.util.List;

public interface TargetFilter {
    List<Role> filterTargets(Role subject, List<Role> targets);
}
