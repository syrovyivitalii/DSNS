package LDUBGD.DSNS.repository;

import LDUBGD.DSNS.model.ActionInEmergencies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActionInEmergenciesRepository extends JpaRepository<ActionInEmergencies, Integer> {

//    @Query(value = "select action_emergencies from action_in_emergencies ", nativeQuery = true)
//    String getActionEmergencies();

    @Query(value = "select home from action_in_emergencies ", nativeQuery = true)
    String getHome1();

    @Query(value = "select min_risk from action_in_emergencies ", nativeQuery = true)
    String getMinRisk1();

    @Query(value = "select emergency_suitcase_part_one from action_in_emergencies ", nativeQuery = true)
    String getEmergencySuitcasePartOne1();

    @Query(value = "select emergency_suitcase_part_two from action_in_emergencies ", nativeQuery = true)
    String getEmergencySuitcasePartTwo1();

    @Query(value = "select download_air_alarm from action_in_emergencies ", nativeQuery = true)
    String getDownloadAirAlarm1();

    @Query(value = "select actions_during_air_alarm from action_in_emergencies ", nativeQuery = true)
    String getActionsDuringAirAlarm1();

    @Query(value = "select actions_during_war from action_in_emergencies ", nativeQuery = true)
    String getActionsDuringWar1();

    @Query(value = "select actions_during_shelling from action_in_emergencies ", nativeQuery = true)
    String getActionsDuringShelling1();

    @Query(value = "select actions_during_artillery_shelling from action_in_emergencies ", nativeQuery = true)
    String getActionsDuringArtilleryShelling1();

    @Query(value = "select action_in_emergencies_kit from action_in_emergencies ", nativeQuery = true)
    String getFirstAidKit1();

    @Query(value = "select child_fear from action_in_emergencies ", nativeQuery = true)
    String getChildFear1();

    @Query(value = "select explosive_object from action_in_emergencies ", nativeQuery = true)
    String getExplosiveObject1();

    @Query(value = "select thread_of_explosion from action_in_emergencies ", nativeQuery = true)
    String getThreadOfExplosion1();

    @Query(value = "select actions_during_home_shelling from action_in_emergencies ", nativeQuery = true)
    String getActionsDuringHomeShelling1();

    @Query(value = "select radiation_map from action_in_emergencies ", nativeQuery = true)
    String getRadiationMap1();

    @Query(value = "select actions_during_radiation_emergency from action_in_emergencies ", nativeQuery = true)
    String getActionsDuringRadiationEmergency1();

    @Query(value = "select chemical_emergency from action_in_emergencies ", nativeQuery = true)
    String getChemicalEmergency1();

    @Query(value = "select actions_during_return_home_after_radiation from action_in_emergencies ", nativeQuery = true)
    String getReturnHomeAfterRadiation1();

    @Query(value = "select disin_formation from action_in_emergencies ", nativeQuery = true)
    String getDisinFormation1();

    @Query(value = "select communication from action_in_emergencies ", nativeQuery = true)
    String getCommunication1();




}

