package LDUBGD.DSNS.repository;

import LDUBGD.DSNS.model.PsychologicalHelp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PsychologicalHelpRepository extends JpaRepository<PsychologicalHelp, Long> {
    @Query(value = "select psychological_help from first_aid ", nativeQuery = true)
    String getPsychologicalHelp();

    @Query(value = "select algorithm_psychological_help from first_aid ", nativeQuery = true)
    String getAlgorithmPsychologicalHelp();

    @Query(value = "select aggression from first_aid ", nativeQuery = true)
    String getAggression();

    @Query(value = "select fear from first_aid ", nativeQuery = true)
    String getFear();

    @Query(value = "select panic from first_aid ", nativeQuery = true)
    String getPanic();

    @Query(value = "select stupor from first_aid ", nativeQuery = true)
    String getStupor();

    @Query(value = "select weep from first_aid ", nativeQuery = true)
    String getWeep();
}
