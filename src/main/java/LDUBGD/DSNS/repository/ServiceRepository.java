package LDUBGD.DSNS.repository;

import LDUBGD.DSNS.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    @Query(value = "select manu from first_aid ", nativeQuery = true)
    String getMenu();

    @Query(value = "select our_facebook from first_aid ", nativeQuery = true)
    String getOurFacebook();

    @Query(value = "select source from first_aid ", nativeQuery = true)
    String getSource();

    @Query(value = "select actions_after_find_weapons from first_aid ", nativeQuery = true)
    String getActionsAfterFindWeapons();
}
