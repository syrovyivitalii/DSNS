package LDUBGD.DSNS.repository;

import LDUBGD.DSNS.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegionsRepository extends JpaRepository<Community, Integer> {
    @Query(value = "select * from get_sub_region(:a_id)",nativeQuery = true)
    List<Community> getSubRegion(int a_id);
}
