//package fr.utbm.coreboot.Service;
//
//import fr.utbm.schoolmaven.coreboot.repository.HibernateCourseDAO;
//import fr.utbm.schoolmaven.coreboot.entity.Course;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import javax.transaction.Transactional;
//
//@Transactional
//@Service
//public class CourseService {
//
//    @Autowired
//    private HibernateCourseDAO hibernateCourseDao;
//
//    public List<Course> all(){
//        return hibernateCourseDao.all();
//    }
//
//
//    public void addCourses(Course c) {
//        this.hibernateCourseDao.addCourses(c);
//    }
//
//    public void updateCourse(Course c) {
//        this.hibernateCourseDao.updateCourse(c);
//    }
//
//    public void removeCourses(String id) {
//        this.hibernateCourseDao.removeCourse(id);
//    }
//    public List<Course> showCoursesByName(String courseName)
//    {
//        List<Course> courses;
//        courses = hibernateCourseDao.getCourseByName(courseName);
//        return courses;
//    }
//}
