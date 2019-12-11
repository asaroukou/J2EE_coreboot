package fr.utbm.coreboot.Service;

import fr.utbm.coreboot.Entity.Course;
import fr.utbm.coreboot.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> all() {
        return this.courseRepository.findAll();
    }

    public Course findCourse(String code) {
        return courseRepository.findById(code).get();
    }

    public List<Course> allByKeyword(String keyword) {
        return this.courseRepository
                .findCourseByCodeContainingOrTitleContaining(keyword, keyword);
    }

    public List<Course> allBySessionDate(Date date) {
        return this.courseRepository.findCourseByOpenSessionAndDate(date);
    }

    public List<Course> allByLocation(int locationId) {
        return this.courseRepository.findCourseByLocation(locationId);
    }

    public Course addCourse(Course c) {
        return this.courseRepository.save(c);
    }

    public void updateCourse(Course c) {
        this.courseRepository.save(c);
    }

    public void removeCourses(String code) {
        this.courseRepository.deleteById(code);
    }


}
