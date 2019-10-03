package ua.bibliy.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "skill")
public class Skill {
    private  int id;
    private String name;

    @ManyToMany(mappedBy = "skills",fetch =  FetchType.EAGER)
    Set<Student> studentSet;

    public Skill(){}
    public Skill(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
