package fr.utbm.coreboot.Repository;

import fr.utbm.coreboot.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}