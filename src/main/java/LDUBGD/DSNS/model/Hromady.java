package LDUBGD.DSNS.model;

import lombok.Getter;
import org.geolatte.geom.Geometry;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class Hromady {
    @Id
    private int id;
    // public.geometry(multipolygon, 4326) NULL,
    String region;
//    private Geometry geom;
    String rayon;
    String hromada;
}
