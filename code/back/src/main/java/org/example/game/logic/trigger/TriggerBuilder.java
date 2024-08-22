package org.example.game.logic.trigger;

import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/22
 */
public class TriggerBuilder {

    public static TriggerIdentifier getHurtTrigger(Role subject){
        return build("GETHURT_" + subject.id);
    }

    static TriggerIdentifier build(final String id) {
        String[] parts = id.split("_");
        TriggerIdentifier result = new TriggerIdentifier(parts[0]);
        TriggerIdentifier temp = result;
        for (int i = 1; i < parts.length; i++) {
            temp.setNext(new TriggerIdentifier(parts[i]));
            temp = temp.getNext();
        }
        return result;
    }
}
