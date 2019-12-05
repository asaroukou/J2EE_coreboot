package fr.utbm.schoolmaven.coreboot.controller;

import fr.utbm.schoolmaven.coreboot.entity.Client;
import fr.utbm.schoolmaven.coreboot.entity.Course;
import fr.utbm.schoolmaven.coreboot.entity.CourseSession;
import fr.utbm.schoolmaven.coreboot.service.CourseSessionService;
import fr.utbm.schoolmaven.coreboot.service.LocationService;
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
