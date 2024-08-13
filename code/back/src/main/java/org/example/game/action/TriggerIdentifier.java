package org.example.game.action;

import java.util.Objects;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/8/5
 */
public class TriggerIdentifier {

    private final String id;
    private TriggerIdentifier next;

    public static TriggerIdentifier build(final String id) {
        String[] parts = id.split("_");
        TriggerIdentifier result = new TriggerIdentifier(parts[0]);
        TriggerIdentifier temp = result;
        for (int i = 1; i < parts.length; i++) {
            temp.setNext(new TriggerIdentifier(parts[i]));
            temp = temp.getNext();
        }
        return result;
    }

    private TriggerIdentifier(String id) {
        this.id = id;
        this.next = null;
    }

    public String getId() {
        return id;
    }

    public TriggerIdentifier getNext() {
        return next;
    }

    public boolean hasNext() {
        return next != null;
    }

    private void setNext(TriggerIdentifier next) {
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
