
package fr.utbm.coreboot.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="COURSE")
public class Course implements Serializable {

    @Id
    @Column(name = "CODE", nullable=false)
    private String code;
    
    @Column(name = "TITLE")
    private String title;

    @OneToMany(mappedBy = "course")
    private List<CourseSession> sessions;
    
    public Course() {
        this.sessions = new ArrayList<>();
    }

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
        this.sessions = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Course{" + "code=" + code + ", title=" + title + '}';
    }
    
     public List<CourseSession> getSessions() {
        return sessions;
    }

    public void setSessions(List<CourseSession> sessions) {
        this.sessions = sessions;
    }

}
