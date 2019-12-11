package fr.utbm.coreboot.Controller;

import fr.utbm.coreboot.Entity.Client;
import fr.utbm.coreboot.Entity.Session;
import fr.utbm.coreboot.Service.ClientService;
import fr.utbm.coreboot.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "/all-client")
    public String allClient(Model model) {
        model.addAttribute("clients", clientService.all());
        return "all-client";
    }


    @RequestMapping(value = "/the-client/{id}", method = RequestMethod.GET)
    public String getAClient(@PathVariable int id, Model model) {
        Client client = clientService.findClient(id);
        List<Session> sessions = sessionService.allOpen();
        sessions.removeAll(client.getSessions());
        model.addAttribute("client", client);
        model.addAttribute("sessions", sessions);
        return "the-client";
    }


    @RequestMapping(value = "/the-client/{client_id}/sessions/{session_id}/add", method = RequestMethod.GET)
    public String submitClientAddSession(@PathVariable int client_id, @PathVariable int session_id) {
        Client client = clientService.findClient(client_id);
        Session session = sessionService.findSessionById(session_id);
        session.addClient(client);
        sessionService.updateSession(session);
        return "redirect:/the-client/" + client_id;
    }

    @RequestMapping(value = "/the-client/{client_id}/sessions/{session_id}/remove", method = RequestMethod.GET)
    public String submitClientRemoveSession(@PathVariable int client_id, @PathVariable int session_id) {
        Client client = clientService.findClient(client_id);
        Session session = sessionService.findSessionById(session_id);
        session.removeClient(client);
        sessionService.updateSession(session);
        return "redirect:/the-client/" + client_id;
    }


    @RequestMapping(value = "/add-client", method = RequestMethod.GET)
    public String addClient() {
        return "add-client";
    }

    @RequestMapping(value = "/add-client", method = RequestMethod.POST)
    public String addClientSubmit(HttpServletRequest request, HttpServletResponse response) {

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Client client = new Client();
        client.setFirstname(firstname);
        client.setLastname(lastname);
        client.setEmail(email);
        client.setPhone(phone);
        client.setAddress(address);
        System.out.println(client);
        clientService.addClient(client);
        return "redirect:/all-client";
    }

}
