package fr.utbm.coreboot.Controller;

import fr.utbm.coreboot.Entity.Session;
import fr.utbm.coreboot.Service.CourseService;
import fr.utbm.coreboot.Service.LocationService;
import fr.utbm.coreboot.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class CourseSessionController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private LocationService locationService;


    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/all-session")
    public String allSessions(Model model) {
        model.addAttribute("sessions", sessionService.all());
        return "all-session";
    }

    @RequestMapping(value = "/add-session", method = RequestMethod.GET)
    public String addSession(Model model) {
        model.addAttribute("locations", locationService.all());
        model.addAttribute("courses", courseService.all());
        return "add-session";
    }

    @RequestMapping(value = "/add-session", method = RequestMethod.POST)
    public String addSessionSubmit(HttpServletRequest request, HttpServletResponse response) {
        Date startDate = new Date();
        Date endDate = new Date();
        String code = request.getParameter("course_code");
        int locationId = Integer.parseInt(request.getParameter("location_id"));
        String startDateStr = request.getParameter("start_date");
        String endDateStr = request.getParameter("end_date");
        int max = Integer.parseInt(request.getParameter("max"));

        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateStr);
            endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Session session = new Session();
        session.setCourse(courseService.findCourse(code));
        session.setLocation(locationService.findLocationById(locationId));
        session.setStartDate(startDate);
        session.setEndDate(endDate);
        session.setMax(max);
        sessionService.addSession(session);
        return "redirect:/all-session";
    }
}
