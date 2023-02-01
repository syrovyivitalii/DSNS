package LDUBGD.DSNS.repository;

import LDUBGD.DSNS.model.Volunteering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VolunteeringRepository extends JpaRepository<Volunteering, Long> {
    @Query(value = "select volunteering from first_aid ", nativeQuery = true)
    String getVolunteering();
    @Query(value = "select volunteering_qustions from first_aid ", nativeQuery = true)
    String getVolunteeringQuestions();

    @Query(value = "select question_one from first_aid ", nativeQuery = true)
    String getQuestionOne();

    @Query(value = "select question_two from first_aid ", nativeQuery = true)
    String getQuestionTwo();

    @Query(value = "select question_three from first_aid ", nativeQuery = true)
    String getQuestionThree();

    @Query(value = "select question_four from first_aid ", nativeQuery = true)
    String getQuestionFour();
}
