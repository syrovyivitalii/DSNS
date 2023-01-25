package LDUBGD.DSNS.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class UserLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phone;
    private double x;
    private double y;
    private Long telegramId;
    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "hromada_id")
    private Hromady hromada;

    public UserLogin() {
    }

    public UserLogin(Long telegramId) {
        this.telegramId = telegramId;
    }

}
