package LDUBGD.DSNS.repository;

import LDUBGD.DSNS.model.ActionInEmergencies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActionInEmergenciesRepository extends JpaRepository<ActionInEmergencies, Long> {

    @Query(value = "select action_emergencies from first_aid ", nativeQuery = true)
    String getActionEmergencies();

    @Query(value = "select home from first_aid ", nativeQuery = true)
    String getHome();

    @Query(value = "select min_risk from first_aid ", nativeQuery = true)
    String getMinRisk();

    @Query(value = "select emergency_suitcase_part_one from first_aid ", nativeQuery = true)
    String getEmergencySuitcasePartOne();

    @Query(value = "select emergency_suitcase_part_two from first_aid ", nativeQuery = true)
    String getEmergencySuitcasePartTwo();

    @Query(value = "select download_air_alarm from first_aid ", nativeQuery = true)
    String getDownloadAirAlarm();

    @Query(value = "select actions_during_air_alarm from first_aid ", nativeQuery = true)
    String getActionsDuringAirAlarm();

    @Query(value = "select actions_during_war from first_aid ", nativeQuery = true)
    String getActionsDuringWar();

    @Query(value = "select actions_during_shelling from first_aid ", nativeQuery = true)
    String getActionsDuringShelling();

    @Query(value = "select actions_during_artillery_shelling from first_aid ", nativeQuery = true)
    String getActionsDuringArtilleryShelling();

    @Query(value = "select first_aid_kit from first_aid ", nativeQuery = true)
    String getFirstAidKit();

    @Query(value = "select child_fear from first_aid ", nativeQuery = true)
    String getChildFear();

    @Query(value = "select explosive_object from first_aid ", nativeQuery = true)
    String getExplosiveObject();

    @Query(value = "select thread_of_explosion from first_aid ", nativeQuery = true)
    String getThreadOfExplosion();

    @Query(value = "select actions_during_home_shelling from first_aid ", nativeQuery = true)
    String getActionsDuringHomeShelling();

    @Query(value = "select radiation_map from first_aid ", nativeQuery = true)
    String getRadiationMap();

    @Query(value = "select actions_during_radiation_emergency from first_aid ", nativeQuery = true)
    String getActionsDuringRadiationEmergency();

    @Query(value = "select chemical_emergency from first_aid ", nativeQuery = true)
    String getChemicalEmergency();

    @Query(value = "select actions_during_return_home_after_radiation from first_aid ", nativeQuery = true)
    String getReturnHomeAfterRadiation();

    @Query(value = "select disin_formation from first_aid ", nativeQuery = true)
    String getDisinFormation();

    @Query(value = "select communication from first_aid ", nativeQuery = true)
    String getCommunication();




}

