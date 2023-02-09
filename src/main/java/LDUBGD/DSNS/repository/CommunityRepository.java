package LDUBGD.DSNS.repository;

import LDUBGD.DSNS.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;

import java.util.List;

public interface CommunityRepository extends JpaRepository<Community, Integer> {
    KeyboardButton keyboardButton1 = new KeyboardButton("Мобільний пристрій");
//        keyboardButton1.setRequestLocation(true);
//    where st_contains(geom,st_setsrid(st_point(24.621005, 49.245382),4326))
    @Query(value = "select * from public.community" +
            " where st_contains(geom,st_setsrid(st_point(:x,:y),4326))",nativeQuery = true)
    List<Community> community(double x, double y);
// TODO: 09.02.23  
    /**
     * select * from get_sub_region(5)
     *
     * --with x
     * SELECT st_xmin(geom),st_ymin(geom), st_xmax(geom), st_ymax(geom), id FROM community c where region_id in (select region_id from get_sub_region(112))
     *
     * SELECT ST_AsText(ST_Envelope(
     * 		ST_Collect(
     * 			ST_GeomFromText('LINESTRING(55 75,125 150)'),
     * 				ST_Point(20, 80))
     * 				)) As wktenv;
     * @param region_id
     * @return
     */
    @Query(value = "select st_xmin(geom),st_ymin(geom), st_xmax(geom), st_ymax(geom)  from community where region_id = :region_id",nativeQuery = true)
    String getRegionBBox(int region_id);

//    @Query(value = "select h from community h where h.alarm is not null")
//    List<Community> getHromadyAlarm();

//    @Query(value = "select * from public.hromady" +
//            " where st_contains(geom,st_setsrid(st_point(:userLogin.x,:userLogin.y),4326))",nativeQuery = true)
//    List<Hromady> hromada(UserLogin userLogin);


//    @Query(value = "select * from public.hromady" +
//            " where st_contains(geom,:p)",nativeQuery = true)
//    Optional<Hromady> hromada(Point p);
//    @Query(value = "select  st_setsrid(st_point(24.621005, 49.245382),4326)", nativeQuery = true)
//    Point p();
}