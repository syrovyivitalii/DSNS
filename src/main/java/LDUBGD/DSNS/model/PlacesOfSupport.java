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
public class PlacesOfSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String support_places,doctors,humanitarian_help,search_service,search_shelters,
    shelters,kyiv,kyiv_region,lviv,kharkiv,odesa,lutsk,poltava,ivanofrankivsk,
    ternopil,chernihiv,vinnitsa,rivne,zhytomyr,chernivtsi,zaporizhzhia,cherkasy,
    mykolaiv,kropyvnytskiy,sumy,uzhgorod,kherson,khmelnytskyi,donetsk,luhansk;
}
