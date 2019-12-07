package fr.utbm.coreboot.Controller;

import fr.utbm.coreboot.Entity.Client;
import fr.utbm.coreboot.Entity.Session;
import fr.utbm.coreboot.Service.SessionService;
import fr.utbm.coreboot.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CourseSessionController {
    
    @Autowired
    private SessionService session;
    
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
        
        model.addAttribute("session", session.findSessionById(id));
        return "coursSession";
    }
    
    @RequestMapping(value="/cours/session/{id}/inscription", method=RequestMethod.GET)
    public String displaySessionbyiIdInscription(@PathVariable int id,Model model){
        Session csession = session.findSessionById(id);
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
