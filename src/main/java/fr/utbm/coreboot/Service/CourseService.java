package fr.utbm.coreboot.Service;

import java.util.Date;
import java.util.List;

import fr.utbm.coreboot.Entity.Course;
import fr.utbm.coreboot.Entity.Location;
import fr.utbm.coreboot.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Transactional
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> all(){
        return (List<Course>) this.courseRepository.findAll();
    }

    public Course findCourse(String code){
        return courseRepository.findById(code).get();
    }

    public List<Course> allByKeyword(String keyword){
        return (List<Course>) this.courseRepository
                .findCourseByCodeContainingOrTitleContaining(keyword, keyword);
    }

    public List<Course> allBySessionDate(Date date){
        return (List<Course>) this.courseRepository.findCourseByOpenSessionAndDate(date);
    }

    public List<Course> allByLocation(int locationId){
        return (List<Course>) this.courseRepository.findCourseByLocation(locationId);
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
