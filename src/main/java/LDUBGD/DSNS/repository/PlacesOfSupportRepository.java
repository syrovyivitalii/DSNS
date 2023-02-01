package LDUBGD.DSNS.repository;

import LDUBGD.DSNS.model.PlacesOfSupport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlacesOfSupportRepository extends JpaRepository<PlacesOfSupport, Long> {

    @Query(value = "select support_places from first_aid ", nativeQuery = true)
    String getSupportPlaces();

    @Query(value = "select doctors from first_aid ", nativeQuery = true)
    String getDoctors();

    @Query(value = "select humanitarian_help from first_aid ", nativeQuery = true)
    String getHumanitarianHelp();

    @Query(value = "select search_service from first_aid ", nativeQuery = true)
    String getSearchService();

    @Query(value = "select search_shelters from first_aid ", nativeQuery = true)
    String getSearchShelters();

    @Query(value = "select shelters from first_aid ", nativeQuery = true)
    String getShelters();

    @Query(value = "select kyiv from first_aid ", nativeQuery = true)
    String getKyiv();

    @Query(value = "select kyiv_region from first_aid ", nativeQuery = true)
    String getKyivRegion();

    @Query(value = "select lviv from first_aid ", nativeQuery = true)
    String getLviv();

    @Query(value = "select kharkiv from first_aid ", nativeQuery = true)
    String getKharkiv();

    @Query(value = "select odesa from first_aid ", nativeQuery = true)
    String getOdesa();

    @Query(value = "select lutsk from first_aid ", nativeQuery = true)
    String getLutsk();

    @Query(value = "select poltava from first_aid ", nativeQuery = true)
    String getPoltava();

    @Query(value = "select ivanofrankivsk from first_aid ", nativeQuery = true)
    String getIvanofrankivsk();

    @Query(value = "select ternopil from first_aid ", nativeQuery = true)
    String getTernopil();

    @Query(value = "select chernihiv from first_aid ", nativeQuery = true)
    String getChernihiv();

    @Query(value = "select vinnitsa from first_aid ", nativeQuery = true)
    String getVinnitsa();

    @Query(value = "select rivne from first_aid ", nativeQuery = true)
    String getRivne();

    @Query(value = "select zhytomyr from first_aid ", nativeQuery = true)
    String getZhytomyr();

    @Query(value = "select chernivtsi from first_aid ", nativeQuery = true)
    String getChernivtsi();

    @Query(value = "select zaporizhzhia from first_aid ", nativeQuery = true)
    String getZaporizhzhia();

    @Query(value = "select cherkasy from first_aid ", nativeQuery = true)
    String getCherkasy();

    @Query(value = "select mykolaiv from first_aid ", nativeQuery = true)
    String getMykolaiv();

    @Query(value = "select kropyvnytskiy from first_aid ", nativeQuery = true)
    String getKropyvnytskiy();

    @Query(value = "select sumy from first_aid ", nativeQuery = true)
    String getSumy();

    @Query(value = "select uzhgorod from first_aid ", nativeQuery = true)
    String getUzhgorod();

    @Query(value = "select kherson from first_aid ", nativeQuery = true)
    String getKherson();

    @Query(value = "select khmelnytskyi from first_aid ", nativeQuery = true)
    String getKhmelnytskyi();

    @Query(value = "select donetsk from first_aid ", nativeQuery = true)
    String getDonetsk();

    @Query(value = "select luhansk from first_aid ", nativeQuery = true)
    String getLuhansk();

    @Query(value = "select dnipro from first_aid ", nativeQuery = true)
    String getDnipro();


}
