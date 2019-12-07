package fr.utbm.coreboot.Service;

import fr.utbm.coreboot.Entity.Location;

import fr.utbm.coreboot.Repository.LocationRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> all() {
        return (List<Location>) locationRepository.findAll();
    }

    public Location addLocation(Location l) {
        return this.locationRepository.save(l);
    }

    public Location findLocationById(int id) {
        return this.locationRepository.findById(id).get();
    }

    public void updateLocation(Location l) {
        this.locationRepository.save(l);
    }

    public void deleteLocation(int id) {
        this.locationRepository.deleteById(id);
    }
}
