package LDUBGD.DSNS.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class Community {
    @Id
    private int id;
    String state;
    String district;
    String community;
}
