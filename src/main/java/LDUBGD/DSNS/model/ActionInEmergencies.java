package LDUBGD.DSNS.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class ActionInEmergencies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String actions_emergencies,home,min_risk,emergency_suitcase_part_one,
        emergency_suitcase_part_two, download_air_alarm,actions_during_air_alarm,
        actions_during_war,actions_during_shelling,actions_during_artillery_shelling,
        first_aid_kit,child_fear,explosive_object,thread_of_explosion,
        actions_during_home_shelling,radiation_map,actions_during_radiation_emergency,
        chemical_emergency,actions_during_return_home_after_radiation,disin_formation,
        communication;
}
