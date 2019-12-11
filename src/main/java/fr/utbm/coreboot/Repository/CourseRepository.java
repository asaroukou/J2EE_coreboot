package fr.utbm.coreboot.Repository;

import fr.utbm.coreboot.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, String> {


    List<Course> findCourseByCodeContainingOrTitleContaining(String a, String b);

    @Query("SELECT C FROM Course C, Session S " +
            "WHERE S.max > S.clients.size  AND C.code = S.course.code " +
            " AND :date BETWEEN S.startDate AND S.endDate ")
    List<Course> findCourseByOpenSessionAndDate(Date date);

    @Query("SELECT C FROM Course C, Session S, Location L " +
            " WHERE S.max > S.clients.size" +
            " AND C.code = S.course.code AND S.location.id = :locationId GROUP BY C.code")
    List<Course> findCourseByLocation(int locationId);


}
