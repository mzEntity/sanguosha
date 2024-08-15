package org.example.game.distance;

import org.example.game.Game;
import org.example.game.role.Role;

import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/14
 */
public class DistanceTable {

    public static HashMap<Role, HashMap<Role, Integer>> getDistanceTable() {
        List<Role> roles = Game.getAliveRoles();
        int aliveCount = roles.size();
        HashMap<Role, HashMap<Role, Integer>> distanceTable = new HashMap<>();
        for (int i = 0; i < aliveCount; i++) {
            Role subject = roles.get(i);
            HashMap<Role, Integer> subjectDistance = new HashMap<>();
            for(int j = 0; j < aliveCount; j++) {
                Role target = roles.get(j);
                subjectDistance.put(target, (i - j + aliveCount) % aliveCount);
            }
            distanceTable.put(subject, subjectDistance);
        }
        return distanceTable;
    }

    public static HashMap<Role, Integer> getSubjectDistance(Role subject) {
        HashMap<Role, HashMap<Role, Integer>> distanceTable = getDistanceTable();
        if(distanceTable.containsKey(subject)){
            return distanceTable.get(subject);
        } else {
            return new HashMap<>();
        }
    }

    public static int getDistance(Role subject, Role target) {
        HashMap<Role, Integer> subjectDistance = getSubjectDistance(subject);
        if(subjectDistance.containsKey(target)){
            return subjectDistance.get(target);
        }
        return -1;
    }
}
