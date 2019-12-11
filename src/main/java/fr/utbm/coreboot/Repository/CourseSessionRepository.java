package fr.utbm.coreboot.Repository;

import fr.utbm.coreboot.Entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseSessionRepository extends JpaRepository<Session, Integer> {

    @Query("SELECT S FROM Session S WHERE S.max > S.clients.size")
    List<Session> findAllOpenSession();
}
