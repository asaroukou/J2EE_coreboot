package fr.utbm.coreboot.Repository;

import fr.utbm.coreboot.Entity.Course;
import fr.utbm.coreboot.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, String> {





    public List<Course> findCourseByCodeContainingOrTitleContaining(String a, String b);

    @Query("SELECT C FROM Course C, Session S " +
            "WHERE S.max > S.clients.size  AND C.code = S.course.code " +
            " AND :date BETWEEN S.startDate AND S.endDate ")
    public List<Course> findCourseByOpenSessionAndDate(Date date);

    @Query("SELECT C FROM Course C, Session S, Location L " +
            " WHERE S.max > S.clients.size" +
            " AND C.code = S.course.code AND S.location.id = :locationId GROUP BY C.code")
    public List<Course> findCourseByLocation(int locationId);


}
