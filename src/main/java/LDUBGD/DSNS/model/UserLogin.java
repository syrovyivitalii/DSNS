package LDUBGD.DSNS.model;

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
    private Double x;
    private Double y;
    private Long telegramId;
    private Long chatId;
    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Community region;

    public UserLogin() {
    }

    public UserLogin(Long telegramId, Long chatId) {
        this.telegramId = telegramId;
        this.chatId = chatId;
    }

}
