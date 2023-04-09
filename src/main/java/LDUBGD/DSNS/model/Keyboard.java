package LDUBGD.DSNS.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table (name = "keyboard",schema = "public")
@Data
public class Keyboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String menu;
    private String keyboard;
    private Integer buttons_per_row;
}
