//package fr.utbm.coreboot.Service;
//
//import fr.utbm.schoolmaven.coreboot.entity.CourseSession;
//import org.springframework.stereotype.Service;
//import fr.utbm.schoolmaven.coreboot.repository.HibernateCourseSessionDAO;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Locale;
//import org.springframework.beans.factory.annotation.Autowired;
//import javax.transaction.Transactional;
//
//
//
//@Transactional
//@Service
//public class CourseSessionService {
//    @Autowired
//    private HibernateCourseSessionDAO hibernateCoursSessionDao;
//
//    public List<CourseSession> all(){
//        return hibernateCoursSessionDao.all();
//    }
//
//    public void addSession(CourseSession c) {
//        this.hibernateCoursSessionDao.addSession(c);
//    }
//
//     public void updateSession(CourseSession c) {
//        this.hibernateCoursSessionDao.updateSession(c);
//    }
//
//    public CourseSession findById(Integer id) {
//        return this.hibernateCoursSessionDao.findById(id);
//    }
//
//    public void removeSession(Integer id) {
//        this.hibernateCoursSessionDao.removeSession(id);
//    }
//
//
// public List<CourseSession> getCourseSessionFilter(String city, String  title, String dateSession) throws ParseException
//    {
//        List<CourseSession> courseSessions;
//        courseSessions = hibernateCoursSessionDao.getCourseSessionByLocationTitleDate(city, title, dateSession);
//        return courseSessions;
//    }
//
//
//    public List<CourseSession> getCourseSessionByLocationTitle(String city,String title)
//    {
//        List<CourseSession> courseSessions;
//        courseSessions = hibernateCoursSessionDao.getCourseSessionByLocationTitle(city,title);
//        return courseSessions;
//    }
//
//
//}
