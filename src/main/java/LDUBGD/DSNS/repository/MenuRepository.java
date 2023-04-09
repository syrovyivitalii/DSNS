package LDUBGD.DSNS.repository;

import LDUBGD.DSNS.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MenuRepository extends JpaRepository <Menu,Long> {
    @Query(value = "select u from Menu u where u.name = :name")
    Menu findByNameMenu(String name);
}
