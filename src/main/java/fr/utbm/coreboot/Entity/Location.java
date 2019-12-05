package fr.utbm.coreboot.Entity;

import javax.persistence.*;
import java.io.Serializable;

//import org.hibernate.annotations.Entity;

@Entity
@Table(name = "LOCATION")
public class Location implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    private int id;
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    private String city;

    public Location() {

    }

    public Location(String city) {
        this.city = city;
    }
    
    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", city=" + city + '}';
    }
}
