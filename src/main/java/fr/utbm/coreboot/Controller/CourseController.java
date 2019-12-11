package fr.utbm.coreboot.Controller;

import fr.utbm.coreboot.Entity.Course;
import fr.utbm.coreboot.Service.CourseService;
import fr.utbm.coreboot.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    LocationService locationService;
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/all-course")
    public String allCourses(Model model) {
        model.addAttribute("courses", courseService.all());
        model.addAttribute("locations", locationService.all());
        return "all-course";
    }

    @RequestMapping(value = "/add-course", method = RequestMethod.GET)
    public String addCourse() {
        return "add-course";
    }

    @RequestMapping(value = "/add-course", method = RequestMethod.POST)
    public String addCourseSubmit(HttpServletRequest request, HttpServletResponse response) {

        String code = request.getParameter("code");
        String title = request.getParameter("title");

        Course course = new Course();
        course.setCode(code);
        course.setTitle(title);
        courseService.addCourse(course);
        return "redirect:/all-course";
    }

    @RequestMapping(value = "/search-course", method = RequestMethod.POST)
    public String searchCourseSubmit(HttpServletRequest request, HttpServletResponse response, Model model) {

        String code = request.getParameter("code");
        String date = request.getParameter("date");
        String locationId = request.getParameter("location_id");
        String filter = null;
        List<Course> courses = new ArrayList<>();
        if (code != null && !code.isEmpty()) {
            filter = "Filtre par mot clé";
            courses = courseService.allByKeyword(code);
        }

        if (date != null && !date.isEmpty()) {
            Date sessionDate = null;
            try {
                sessionDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            filter = "Filtre par date de session";
            courses = courseService.allBySessionDate(sessionDate);
        }

        if (locationId != null && !locationId.isEmpty()) {
            filter = "Filtre par site";
            courses = courseService.allByLocation(Integer.parseInt(locationId));
        }
        model.addAttribute("courses", courses);
        model.addAttribute("filter", filter);
        model.addAttribute("locations", locationService.all());
        if (courses.size() > 0 || filter != null)
            return "all-course";
        else
            return "redirect:/all-course";
    }


}
