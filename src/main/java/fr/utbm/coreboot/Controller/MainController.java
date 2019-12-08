package fr.utbm.coreboot.Controller;
import fr.utbm.coreboot.Entity.Client;
import fr.utbm.coreboot.Repository.ClientRepository;
import fr.utbm.coreboot.Service.ClientService;
import fr.utbm.coreboot.Service.CourseService;
import fr.utbm.coreboot.Service.LocationService;
import fr.utbm.coreboot.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller // This means that this class is a Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    ClientService clientService;

    @Autowired
    CourseService courseService;

    @Autowired
    SessionService sessionService;

    @Autowired
    LocationService locationService;

    @RequestMapping (value = "/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("clients", clientService.all());
        return "hello";
    }

    @RequestMapping(value = "/all-client")
    public String allClient(Model model) {
        model.addAttribute("clients", clientService.all());
        return "all-client";
    }

    @RequestMapping(value = "/add-client")
    public String addClient() {
        return "add-client";
    }



    @RequestMapping(value = "/all-course")
    public String allCourses(Model model) {
        model.addAttribute("courses", courseService.all());
        return "all-course";
    }

    @RequestMapping(value = "/add-course")
    public String addCourse() {
        return "add-course";
    }




    @RequestMapping(value = "/all-site")
    public String allSites(Model model) {
        model.addAttribute("locations", locationService.all());
        return "all-site";
    }

    @RequestMapping(value = "/add-site")
    public String addSite() {
        return "add-site";
    }
    @RequestMapping(value = "/all-session")
    public String allSessions(Model model) {
        model.addAttribute("sessions", sessionService.all());
        return "all-session";
    }

    @RequestMapping(value = "/add-session")
    public String addSession() {
        return "add-session";
    }

}