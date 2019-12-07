package fr.utbm.coreboot.Repository;

import fr.utbm.coreboot.Entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSessionRepository extends JpaRepository<Session, Integer> {
}
