package fr.utbm.coreboot.Controller;


import fr.utbm.coreboot.Entity.Client;
import fr.utbm.coreboot.Repository.ClientRepository;
import fr.utbm.coreboot.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    private ClientService clientService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewClient (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Client n = new Client();
        n.setFirstname(name);
        n.setEmail(email);
        clientService.addClient(n);
        return "Saved";
    }

    @PostMapping(path="/update") // Map ONLY POST Requests
    public @ResponseBody String updateClient (@RequestParam int id
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        clientService.updateClient(id, email);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Client> getAllUsers() {
        // This returns a JSON or XML with the users
        return clientService.all();
    }
}