package fr.utbm.coreboot.Service;

import fr.utbm.coreboot.Entity.Client;
import fr.utbm.coreboot.Repository.ClientRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ClientService {

    @Autowired(required = true)
    private ClientRepository clientRepository;

    public List<Client> all() {
        return (List<Client>) clientRepository.findAll();
    }

    public void addClient(Client c) {
        System.out.println("fr.utbm.schoolmaven.coreboot.service.ClientService.addClient()");
        System.out.println(c);
        this.clientRepository.save(c);
    }

    public void updateClient(int id, String email) {
       Optional<Client> client =  this.clientRepository.findById(id);
        if(client.isPresent()){
            Client c = client.get();
            c.setEmail("abdelsaroukou@gmail.com");
            clientRepository.save(c);
        };
    }
//
//    public Client findClient(Integer id) {
//        return this.clientRepository.findClient(id);
//    }
//
//    public void deleteClient(Integer id) {
//        this.clientRepository.deleteClient(id);
//    }
}
