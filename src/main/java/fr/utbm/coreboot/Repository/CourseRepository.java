package fr.utbm.coreboot.Repository;

import fr.utbm.coreboot.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
}
