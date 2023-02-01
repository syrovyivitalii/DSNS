package LDUBGD.DSNS.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class FirstAid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bleeding,external_bleeding,internal_bleeding,limb_amputation,limb_bleeding,head_neck_bleeding,body_bleeding,bone_injuries,
            open_fracture,closed_fracture,dislocation,burns,thermal_burns,chemical_burns,electric_burns,frostbite,cpr,cpr_old,cpr_young,cpr_baby,
            chest_injury,penetrating_injury,closed_injury,gunshot_wound,spine_injury,safely_place,danger_place,traumatic_brain_injury;

    public FirstAid(){}


}
