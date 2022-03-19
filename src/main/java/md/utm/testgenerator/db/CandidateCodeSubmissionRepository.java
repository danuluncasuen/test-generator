package md.utm.testgenerator.db;

import md.utm.testgenerator.entity.CandidateCodeSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateCodeSubmissionRepository extends JpaRepository<CandidateCodeSubmission, Long> {
}
