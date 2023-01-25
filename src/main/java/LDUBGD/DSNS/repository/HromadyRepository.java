package LDUBGD.DSNS.repository;

import LDUBGD.DSNS.model.Hromady;
import LDUBGD.DSNS.model.UserLogin;
import org.geolatte.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;

import java.util.List;
import java.util.Optional;

public interface HromadyRepository extends JpaRepository<Hromady, Integer> {
    KeyboardButton keyboardButton1 = new KeyboardButton("Мобільний пристрій");
//        keyboardButton1.setRequestLocation(true);
//    where st_contains(geom,st_setsrid(st_point(24.621005, 49.245382),4326))
    @Query(value = "select * from public.hromady" +
            " where st_contains(geom,st_setsrid(st_point(:x,:y),4326))",nativeQuery = true)
    List<Hromady> hromada(double x, double y);

//    @Query(value = "select * from public.hromady" +
//            " where st_contains(geom,st_setsrid(st_point(:userLogin.x,:userLogin.y),4326))",nativeQuery = true)
//    List<Hromady> hromada(UserLogin userLogin);


//    @Query(value = "select * from public.hromady" +
//            " where st_contains(geom,:p)",nativeQuery = true)
//    Optional<Hromady> hromada(Point p);
//    @Query(value = "select  st_setsrid(st_point(24.621005, 49.245382),4326)", nativeQuery = true)
//    Point p();
}