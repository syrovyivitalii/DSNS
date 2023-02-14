package LDUBGD.DSNS.repository;

import LDUBGD.DSNS.model.ActionEmergencies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActionEmergenciesRepository extends JpaRepository<ActionEmergencies, Integer> {
    @Query(value = "select ac from ActionEmergencies ac where ac.nameAction = :nameAction")
    ActionEmergencies getByName(String nameAction);

}
