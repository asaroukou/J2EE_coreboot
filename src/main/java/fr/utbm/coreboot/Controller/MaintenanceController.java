package fr.utbm.coreboot.Controller;

import fr.utbm.coreboot.Entity.Client;
import fr.utbm.coreboot.Entity.Course;
import fr.utbm.coreboot.Entity.CourseSession;
import fr.utbm.coreboot.Service.CourseSessionService;
import fr.utbm.coreboot.Service.LocationService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class MaintenanceController {
    
    @RequestMapping(value="/maintain")
    public String showMaintain(){
      return "maintenance";
    }

    @RequestMapping(value="/error")
    public String showError(Model model,HttpServletRequest request){
      
      model.addAttribute("status", request.getAttribute("javax.servlet.error.status_code"));
      model.addAttribute("reason", request.getAttribute("javax.servlet.error.message"));
        
      return "notfound";
      
    }
  
    
}
