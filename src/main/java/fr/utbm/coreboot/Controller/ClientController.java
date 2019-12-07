/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coreboot.Controller;

import fr.utbm.coreboot.Entity.Client;
import fr.utbm.coreboot.Entity.CourseSession;
import fr.utbm.coreboot.Service.ClientService;
import fr.utbm.coreboot.Service.CourseSessionService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.*;
//portlet.ModelAndView;


@Controller
public class ClientController {
   
    @Autowired
    private ClientService clientservice; 
    
    @Autowired
    private CourseSessionService session;
    
    @RequestMapping(value = "/register/{id}", method = RequestMethod.POST)
    public String registerClient(@PathVariable int id,@ModelAttribute("client")Client client,BindingResult result,Model model ){
       
        
        return "validation";
    }

    
    @RequestMapping(value = "{id}/register")
    public String registerClient(@PathVariable int id,Model model ){
        
        return "validation";
    }
}
