package fr.utbm.coreboot.Repository;

import fr.utbm.coreboot.Entity.CourseSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSessionRepository extends JpaRepository<CourseSession, Integer> {
}
