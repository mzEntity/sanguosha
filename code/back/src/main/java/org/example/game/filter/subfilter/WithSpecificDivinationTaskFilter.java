package org.example.game.filter.subfilter;

import org.example.game.board.card.concrete.skill.delayed.DelayedSkillType;
import org.example.game.filter.TargetFilter;
import org.example.game.role.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public class WithSpecificDivinationTaskFilter implements TargetFilter {
    private DelayedSkillType delayedSkillType;
    public WithSpecificDivinationTaskFilter(DelayedSkillType delayedSkillType) {
        this.delayedSkillType = delayedSkillType;
    }

    @Override
    public List<Role> filterTargets(Role subject, List<Role> targets) {
        List<Role> result = new ArrayList<>();
        for (Role target : targets) {
            if(target.getPlayerArea().getDivinationArea().containTask(this.delayedSkillType)){
                result.add(target);
            }
        }
        return result;
    }
}
