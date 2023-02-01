package LDUBGD.DSNS.repository;

import LDUBGD.DSNS.model.FirstAid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FirstAidRepository extends JpaRepository<FirstAid, Long> {

    @Query(value = "select bleeding from first_aid ", nativeQuery = true)
    String getBleeding();

    @Query(value = "select external_bleeding from first_aid ", nativeQuery = true)
    String getExternalBleeding();

    @Query(value = "select internal_bleeding from first_aid ", nativeQuery = true)
    String getInternalBleeding();

    @Query(value = "select limb_amputation from first_aid ", nativeQuery = true)
    String getLimbAmputation();

    @Query(value = "select limb_bleeding from first_aid ", nativeQuery = true)
    String getLimbBleeding();

    @Query(value = "select head_neck_bleeding from first_aid ", nativeQuery = true)
    String getHeadNeckBleeding();

    @Query(value = "select body_bleeding from first_aid ", nativeQuery = true)
    String getBodyBleeding();

    @Query(value = "select bone_injuries from first_aid ", nativeQuery = true)
    String getBoneInjuries();

    @Query(value = "select open_fracture from first_aid ", nativeQuery = true)
    String getOpenFracture();

    @Query(value = "select closed_fracture from first_aid ", nativeQuery = true)
    String getClosedFracture();

    @Query(value = "select dislocation from first_aid ", nativeQuery = true)
    String getDislocation();

    @Query(value = "select burns from first_aid ", nativeQuery = true)
    String getBurns();

    @Query(value = "select thermal_burns from first_aid ", nativeQuery = true)
    String getThermalBurns();

    @Query(value = "select chemical_burns from first_aid ", nativeQuery = true)
    String getChemicalBurns();

    @Query(value = "select electric_burns from first_aid ", nativeQuery = true)
    String getElectricBurns();

    @Query(value = "select frostbite from first_aid ", nativeQuery = true)
    String getFrostbite();

    @Query(value = "select cpr from first_aid ", nativeQuery = true)
    String getCPR();

    @Query(value = "select cpr_old from first_aid ", nativeQuery = true)
    String getCPR_Old();

    @Query(value = "select cpr_young from first_aid ", nativeQuery = true)
    String getCPR_Young();

    @Query(value = "select cpr_baby from first_aid ", nativeQuery = true)
    String getCPR_Baby();

    @Query(value = "select chest_injury from first_aid ", nativeQuery = true)
    String getChestInjury();

    @Query(value = "select penetrating_injury from first_aid ", nativeQuery = true)
    String getPenetratingInjury();

    @Query(value = "select closed_injury from first_aid ", nativeQuery = true)
    String getClosedInjury();

    @Query(value = "select gunshot_wound from first_aid ", nativeQuery = true)
    String getGunshotWound();

    @Query(value = "select spine_injury from first_aid ", nativeQuery = true)
    String getSpineInjury();

    @Query(value = "select safely_place from first_aid ", nativeQuery = true)
    String getSafelyPlace();

    @Query(value = "select danger_place from first_aid ", nativeQuery = true)
    String getDangerPlace();

    @Query(value = "select traumatic_brain_injury from first_aid ", nativeQuery = true)
    String getTraumaticBrainInjury();






}
