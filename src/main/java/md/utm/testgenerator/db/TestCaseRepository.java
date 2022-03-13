package md.utm.testgenerator.db;

import md.utm.testgenerator.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
}
