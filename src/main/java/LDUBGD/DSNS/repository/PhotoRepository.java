package LDUBGD.DSNS.repository;

import LDUBGD.DSNS.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PhotoRepository extends JpaRepository <Photo, Long> {
    @Query(value = "select u from Photo u where u.menu = :menu")
    Photo findByMenu(String menu);
}
