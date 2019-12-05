//package fr.utbm.coreboot.Service;
//
//import fr.utbm.schoolmaven.coreboot.entity.Location;
//
//import fr.utbm.schoolmaven.coreboot.entity.Location;
//import fr.utbm.schoolmaven.coreboot.repository.HibernateLocationDAO;
//import java.util.List;
//import javax.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
//@Transactional
//@Service
//public class LocationService {
//
//    @Autowired
//    private HibernateLocationDAO hibernateLocationDao;
//
//    public LocationService(){
//        hibernateLocationDao = new HibernateLocationDAO();
//    }
//
//    public List<Location> all(){
//        return hibernateLocationDao.all();
//    }
//
//
//    public void addLocation(Location c) {
//        this.hibernateLocationDao.addLocation(c);
//    }
//
//    public void updateLocation(Location c) {
//        this.hibernateLocationDao.updateLocation(c);
//    }
//
//    public void removeLocation(int id) {
//        this.hibernateLocationDao.deleteLocation(id);
//    }
//}
