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