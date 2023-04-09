package LDUBGD.DSNS.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table (name = "photo" , schema = "public")
@Data
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String menu;
    private String url;
}
