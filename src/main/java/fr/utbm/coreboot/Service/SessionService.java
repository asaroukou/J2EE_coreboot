package fr.utbm.coreboot.Service;

import fr.utbm.coreboot.Entity.Session;
import fr.utbm.coreboot.Repository.CourseSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class SessionService {

    @Autowired
    private CourseSessionRepository courseSessionRepository;

    public List<Session> all() {
        return courseSessionRepository.findAll();
    }

    public List<Session> allOpen() {
        return courseSessionRepository.findAllOpenSession();
    }


    public Session addSession(Session cs) {
        return this.courseSessionRepository.save(cs);
    }

    public Session findSessionById(int id) {
        return this.courseSessionRepository.findById(id).get();
    }


    public Session updateSession(Session cs) {
        return this.courseSessionRepository.save(cs);
    }

    public void deleteCourseSession(int id) {
        this.courseSessionRepository.deleteById(id);
    }
}
