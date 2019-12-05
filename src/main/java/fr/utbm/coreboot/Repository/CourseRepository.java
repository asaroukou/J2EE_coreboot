package fr.utbm.coreboot.Repository;

import fr.utbm.coreboot.Entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
}
