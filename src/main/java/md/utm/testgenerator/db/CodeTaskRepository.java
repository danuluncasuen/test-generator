package md.utm.testgenerator.db;

import md.utm.testgenerator.entity.CodeTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeTaskRepository extends JpaRepository<CodeTask, Long> {
}
