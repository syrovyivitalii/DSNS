package LDUBGD.DSNS.repository;

import LDUBGD.DSNS.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    @Query(value = "select menu from service ", nativeQuery = true)
    String getMenu();

    @Query(value = "select our_facebook from service ", nativeQuery = true)
    String getOurFacebook();

    @Query(value = "select source from service ", nativeQuery = true)
    String getSource();

    @Query(value = "select actions_after_find_weapons from service ", nativeQuery = true)
    String getActionsAfterFindWeapons();
}
