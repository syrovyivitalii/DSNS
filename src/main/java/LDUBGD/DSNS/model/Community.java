package LDUBGD.DSNS.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Entity
public class Community {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "region_id")
    Regions regionId;
    String state;
    String district;
    String community;
}
