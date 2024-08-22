package org.example.game.logic.trigger;

import java.util.Objects;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/5
 */
public class TriggerIdentifier {

    private final String id;
    private TriggerIdentifier next;

    TriggerIdentifier(String id) {
        this.id = id;
        this.next = null;
    }

    TriggerIdentifier getNext() {
        return next;
    }

    boolean hasNext() {
        return next != null;
    }

    void setNext(TriggerIdentifier next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TriggerIdentifier that = (TriggerIdentifier) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        if(this.next == null){
            return id;
        } else {
            return id + "_" + next;
        }
    }
}
