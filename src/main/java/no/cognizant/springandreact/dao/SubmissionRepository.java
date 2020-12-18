package no.cognizant.springandreact.dao;

import no.cognizant.springandreact.domain.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, Integer> {

    @Query(value = "SELECT * FROM Submissions s limit 3", nativeQuery = true)
    List<Submission> getTop3Coder();
}
