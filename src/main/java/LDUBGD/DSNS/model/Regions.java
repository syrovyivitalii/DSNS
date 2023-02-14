package LDUBGD.DSNS.model;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
@Data
@Proxy(lazy=false)
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
        res.add("<b>"+getRegionName()+"</b>");
        if (district != null) {
            res.add(district.getRegionName());
        }
        if (state != null) {
            res.add(state.getRegionName());
        }
        return res.toString();
    }
}
