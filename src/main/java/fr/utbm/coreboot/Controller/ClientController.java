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
import org.springframework.web.bind.annotation.*;
//portlet.ModelAndView;


@RestController
@RequestMapping(value = "/client-management", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ClientController {
   
    @Autowired
    private ClientService clientService;

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
