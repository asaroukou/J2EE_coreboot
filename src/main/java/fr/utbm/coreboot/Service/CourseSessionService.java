package fr.utbm.coreboot.Service;

import fr.utbm.coreboot.Entity.CourseSession;
import org.springframework.stereotype.Service;
import fr.utbm.coreboot.Repository.CourseSessionRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;

@Transactional
@Service
public class CourseSessionService {

    @Autowired
    private CourseSessionRepository courseSessionRepository;

    public List<CourseSession> all() {
        return (List<CourseSession>) courseSessionRepository.findAll();
    }

    public void addCourseSession(CourseSession cs) {
        this.courseSessionRepository.save(cs);
    }

    public CourseSession findCourseSessionClientById(int id) {
        return this.courseSessionRepository.findById(id).get();
    }

    public void updateCourseSession(CourseSession cs) {
        this.courseSessionRepository.save(cs);
    }

    public void deleteCourseSession(int id) {
        this.courseSessionRepository.deleteById(id);
    }
}
