package fr.utbm.coreboot.Repository;

import fr.utbm.coreboot.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
