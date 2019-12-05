/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.coreboot.Entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CLIENT")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    
    @Column(name = "LASTNAME")
    private String lastname;
    
    @Column(name = "FIRST_NAME")
    private String firstname;
    
    @Column(name = "ADRESS")
    private String address;
    
    @Column(name = "PHONE")
    private String phone;
    
    @Pattern(regexp = ".+@.+\\..+", message = "Email Non valide")
    @Column(name = "EMAIL")
    private String email;
    
    @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},mappedBy = "clients")
    private List<CourseSession> sessions;
    
    public List<CourseSession> getSessions() {
        return sessions;
    }
    public void setSessions(List<CourseSession> sessions) {
        this.sessions = sessions;
    }
    private int courseSessionId;

    public Client() {
        this.sessions = new ArrayList<>();
    }

    public Client(int id, String lastname, String firstname, String address, String phone, String email) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.sessions = new ArrayList<>();
        //this.courseSessionId = courseSessionId;
    }

     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public int getCourseSessionId() {
        return courseSessionId;
    }

    public void setCourseSessionId(int courseSessionId) {
        this.courseSessionId = courseSessionId;
    }*/

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", address=" + address + ", phone=" + phone + ", email=" + email + ", courseSessionId=" + courseSessionId + '}';
    }

    
}
