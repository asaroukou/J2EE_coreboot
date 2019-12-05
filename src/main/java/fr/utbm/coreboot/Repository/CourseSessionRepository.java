package fr.utbm.coreboot.Repository;

import fr.utbm.coreboot.Entity.CourseSession;
import org.springframework.data.repository.CrudRepository;

public interface CourseSessionRepository extends CrudRepository<CourseSession, Integer> {
}
