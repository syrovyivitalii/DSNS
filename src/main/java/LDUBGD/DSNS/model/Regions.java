package LDUBGD.DSNS.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Regions {
    @Id
    int region_id;
    String region_name;
    String region_type;
    int state_id;
    int district_id;
}
