package LDUBGD.DSNS.model;

import lombok.Data;

import java.util.Arrays;

@Data
public class Alert {
    String regionId;
    String regionType;
    String regionName;
    String lastUpdate;
    ActiveAlerts[] activeAlerts;

    @Override
    public String toString() {
//        return "Alert{" +
//                "regionId='" + regionId + '\'' +
//                ", regionType='" + regionType + '\'' +
//                ", regionName='" + regionName + '\'' +
//                ", lastUpdate='" + lastUpdate + '\'' +
//                ", activeAlerts=" + Arrays.toString(activeAlerts) +
//                '}';
        return regionName + ": " + Arrays.stream(activeAlerts).findFirst().get().type;
    }
}
