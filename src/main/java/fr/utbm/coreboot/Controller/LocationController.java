package fr.utbm.coreboot.Controller;

import fr.utbm.coreboot.Entity.Location;
import fr.utbm.coreboot.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LocationController {

    @Autowired
    LocationService locationService;

    @RequestMapping(value = "/all-site")
    public String allSites(Model model) {
        model.addAttribute("locations", locationService.all());
        return "all-site";
    }

    @RequestMapping(value = "/add-site", method = RequestMethod.GET)
    public String addSite() {
        return "add-site";
    }

    @RequestMapping(value = "/add-site", method = RequestMethod.POST)
    public String addSiteSubmit(HttpServletRequest request, HttpServletResponse response) {
        String city = request.getParameter("city");
        Location location = new Location();
        location.setCity(city);
        locationService.addLocation(location);
        return "redirect:/all-site";
    }

}
