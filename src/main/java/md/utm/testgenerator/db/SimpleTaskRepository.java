package md.utm.testgenerator.db;

import md.utm.testgenerator.entity.SimpleTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleTaskRepository extends JpaRepository<SimpleTask, Long> {
}
