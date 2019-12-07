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
import java.util.Locale;
import javax.persistence.Temporal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CourseSessionController {
    
    @Autowired
    private CourseSessionService session;
    
    @Autowired
    private LocationService location; 

    
    @RequestMapping(value="/session")
    public String displaySession(Model model){
      model.addAttribute("sessions", session.all());
      model.addAttribute("locations", location.all());    
      
      return "sessionDisplay";
    }
    
//    @RequestMapping(value="/session/filter")
//    public String displaySessionFilter(HttpServletRequest req, Model model) throws ParseException{
//     
//        //filter list 
//        String title = req.getParameter("title");
//        String city = req.getParameter("city");
//        String date = req.getParameter("date");
//        
//
//        List<CourseSession> courseSessions = session.getCourseSessionFilter(city, title,date);    //.getCourseSessionByLocationTitle(city, title);    //.getCourseSessionByLocation(city);    //.getCourseSessionByDate(startdate);    //.getSessionFilterbyLocation(session.all(),city);    //.getCourseSessionFilter(city, date, title);
//        
//        model.addAttribute("sessions", courseSessions);
//        
//        model.addAttribute("locations", location.all());    
//        
//      return "sessionDisplay";
//    }
    
    @RequestMapping(value="/cours/session/{id}", method=RequestMethod.GET)    
    public String displaySessionbyId(@PathVariable int id,Model model){
        
        model.addAttribute("session", session.findCourseSessionClientById(id));
        return "coursSession";
    }
    
    @RequestMapping(value="/cours/session/{id}/inscription", method=RequestMethod.GET)
    public String displaySessionbyiIdInscription(@PathVariable int id,Model model){
        CourseSession csession = session.findCourseSessionClientById(id);
        model.addAttribute("session", csession);
        
        Client client = new Client();
        client.setAddress("");
        client.setFirstname("");
        client.setLastname("");
        client.setPhone("");
        client.setEmail("");
        
        model.addAttribute("client", new Client());
      
        return "clientInscription";
    }

   
    
}
