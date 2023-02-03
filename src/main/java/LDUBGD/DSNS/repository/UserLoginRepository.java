package LDUBGD.DSNS.repository;

import LDUBGD.DSNS.model.Community;
import LDUBGD.DSNS.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
    @Query(value = "select u from UserLogin u where u.telegramId = :telegram_id")
    Optional<UserLogin> findByTelegramId(long telegram_id);

    @Query(value = "select u from UserLogin u where u.region in (:region)")
    List<UserLogin> findByHromada(List<Community> region);
}