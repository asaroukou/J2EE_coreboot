/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coreboot.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
//import org.hibernate.annotations.CascadeType;


@Entity
@Table(name = "SESSION")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Session implements Serializable {

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

    @ManyToMany(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST})
    @JoinTable(
        name="SESSION_CLIENT",
        joinColumns=@JoinColumn(name="SESSION_ID"),
        inverseJoinColumns=@JoinColumn(name="CLIENT_ID")
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
            clients.removeIf(client -> client.getId() == c.getId());
            c.getSessions().remove(this);
   }
    
    public Session() {
        clients = new ArrayList<>();
    }

    public Session(int id, Date startDate, Date endDate, int max) {
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "CourseSession{" + "id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", max=" + max + ", code=" + course.getCode() + ", locationId=" + location.getId() + '}';
    }
    
}
