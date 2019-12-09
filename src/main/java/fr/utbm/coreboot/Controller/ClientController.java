/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coreboot.Controller;

import fr.utbm.coreboot.Entity.Client;
import fr.utbm.coreboot.Service.ClientService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sun.awt.X11.XSystemTrayPeer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
//portlet.ModelAndView;


@Controller
public class ClientController {
   
    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/all-client")
    public String allClient(Model model) {
        model.addAttribute("clients", clientService.all());
        return "all-client";
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


    @GetMapping(value = "/client")
    public List<Client> getAllClient(){
        return clientService.all();
    }

    @PostMapping("/client")
    Client createOrSaveClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }

    @GetMapping("/client/{id}")
    Client getClientById(@PathVariable int id) {
        return clientService.findClient(id);
    }

    @PutMapping("/client/{id}")
    Client updateClient(@RequestBody Client client, @PathVariable int id) {
         Client c =  clientService.findClient(id);
            c.setFirstname(client.getFirstname());
            c.setLastname(client.getLastname());
            c.setEmail(client.getEmail());
            c.setAddress(client.getAddress());
            c.setPhone(client.getPhone());
            c.setEmail(client.getEmail());
            return clientService.updateClient(c);
    }

    @DeleteMapping("/client/{id}")
    void deleteClient(@PathVariable int id) {
        clientService.deleteClient(id);
    }

}
