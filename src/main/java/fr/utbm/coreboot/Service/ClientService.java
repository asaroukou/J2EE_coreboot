package fr.utbm.coreboot.Service;

import fr.utbm.coreboot.Entity.Client;
import fr.utbm.coreboot.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientService {

    @Autowired(required = true)
    private ClientRepository clientRepository;

    public List<Client> all() {
        return clientRepository.findAll();
    }

    public Client addClient(Client c) {
        return this.clientRepository.save(c);
    }

    public Client findClient(int id) {
        return this.clientRepository.findById(id).get();
    }

    public Client updateClient(Client c) {
        return this.clientRepository.save(c);
    }

    public void deleteClient(int id) {
        this.clientRepository.deleteById(id);
    }

}
