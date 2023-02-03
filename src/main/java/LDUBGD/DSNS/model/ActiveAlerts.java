package LDUBGD.DSNS.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ActiveAlerts implements Serializable {
    static String AIR = "Повітряна тривога";
    static String ARTILLERY = "Загроза артобстрілу";
    static String URBAN_FIGHTS = "Вуличні бої";
    static String CHEMICAL = "Хімічна небезпека";
    static String NUCLEAR = "Радіаційна небезпека";
    //    static String INFO = "INFO";
//   static String  UNKNOWN = "UNKNOWN";
    String regionId;
    String regionType;
    /**
     * UNKNOWN, AIR, ARTILLERY, URBAN_FIGHTS, CHEMICAL, NUCLEAR, INFO
     */
    String type;
    String lastUpdate;

    public String getType() {
        if (type.equals("AIR")) {
            return AIR;
        } else if (type.equals("ARTILLERY")) {
            return ARTILLERY;
        } else if (type.equals("URBAN_FIGHTS")) {
            return URBAN_FIGHTS;
        } else if (type.equals("CHEMICAL")) {
            return CHEMICAL;
        } else if (type.equals("NUCLEAR")) {
            return NUCLEAR;
        }
        return type;
    }
}
