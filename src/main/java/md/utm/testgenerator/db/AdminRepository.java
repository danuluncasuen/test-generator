package md.utm.testgenerator.db;

import md.utm.testgenerator.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String s);
}
