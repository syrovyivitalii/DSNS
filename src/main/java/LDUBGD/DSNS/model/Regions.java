package LDUBGD.DSNS.model;

import lombok.Data;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
@Data
public class Regions {
    @Id
    Integer regionId;
    @Column(name = "region_type")
    String regionType;
    @ManyToOne
    @JoinColumn(name = "state_id")
    Regions state;
    @ManyToOne
    @JoinColumn(name = "district_id")
    Regions district;
    @Column(name = "region_name")
    String regionName;

    public String getText(String delimiter) {
        StringJoiner res = new StringJoiner(delimiter);
        if (state != null) {
            res.add(state.getRegionName());
        }
        if (district != null) {
            res.add(district.getRegionName());
        }
        res.add(getRegionName());
        return res.toString();
    }
}
