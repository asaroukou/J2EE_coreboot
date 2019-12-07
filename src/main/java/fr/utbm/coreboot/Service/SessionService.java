package fr.utbm.coreboot.Service;

import fr.utbm.coreboot.Entity.Session;
import org.springframework.stereotype.Service;
import fr.utbm.coreboot.Repository.CourseSessionRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;

@Transactional
@Service
public class SessionService {

    @Autowired
    private CourseSessionRepository courseSessionRepository;

    public List<Session> all() {
        return (List<Session>) courseSessionRepository.findAll();
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
