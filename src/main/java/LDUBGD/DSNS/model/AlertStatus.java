package LDUBGD.DSNS.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class AlertStatus implements Serializable {
    private long lastActionIndex = -1;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlertStatus that = (AlertStatus) o;
        return lastActionIndex == that.lastActionIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastActionIndex);
    }

    @Override
    public String toString() {
        return "AlertStatus{" +
                "lastActionIndex=" + lastActionIndex +
                '}';
    }
}
