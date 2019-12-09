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











}