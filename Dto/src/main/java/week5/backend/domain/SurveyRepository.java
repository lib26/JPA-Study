package week5.backend.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

    @Query("Select s from Survey  s where s.id = :id")
    Optional<Survey> findById(Long id);
}
