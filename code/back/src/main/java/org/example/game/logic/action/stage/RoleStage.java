package org.example.game.logic.action.stage;

import org.example.game.logic.Action;
import org.example.game.role.Role;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/24
 */
public abstract class RoleStage extends Action {
    protected Role subject;
    protected boolean isSkipped;

    public RoleStage(Role subject) {
        super();
        this.subject = subject;
        this.isSkipped = false;
    }

    public void setSkipped(boolean isSkipped) {
        this.isSkipped = isSkipped;
    }

    public boolean isSkipped() {
        return isSkipped;
    }
}
