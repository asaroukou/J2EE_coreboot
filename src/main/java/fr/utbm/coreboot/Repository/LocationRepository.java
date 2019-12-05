package fr.utbm.coreboot.Repository;

import fr.utbm.coreboot.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
