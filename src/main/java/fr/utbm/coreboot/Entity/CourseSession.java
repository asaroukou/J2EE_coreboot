/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coreboot.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
//import org.hibernate.annotations.CascadeType;


@Entity
@Table(name = "COURSE_SESSION")
public class CourseSession implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    
    @Column(name = "START_DATE", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;
    
    @Column(name = "END_DATE", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endDate;
    
    @Column(name = "MAXIMUM")
    private int max;
    
    @ManyToOne
    @JoinColumn(name="COURSE_CODE")
    private Course course;
    
    @ManyToOne
    @JoinColumn(name="LOCATION_ID")
    private Location location;

    @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
        name="INCLUDE",
        joinColumns=@JoinColumn(name="IDSESSION"),
        inverseJoinColumns=@JoinColumn(name="IDCLIENT")
    )
    private List<Client> clients;
    
    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    
    public void addClient(Client c){
            clients.add(c);
            c.getSessions().add(this);
    }
    
    public void removeClient(Client c){
            clients.remove(c);
            c.getSessions().remove(this);
   }
    
    public CourseSession() {
    }

    public CourseSession(int id, Date startDate, Date endDate, int max) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.max = max;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Course getCode() {
        return course;
    }

    public void setCode(Course course) {
        this.course = course;
    }

    public Location getLocationId() {
        return location;
    }

    public void setLocationId(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "CourseSession{" + "id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", max=" + max + ", code=" + course.getCode() + ", locationId=" + location.getId() + '}';
    }
    
}
