package ua.bibliy.Model;

import javax.persistence.*;
import java.util.Set;

public class Student {

    @Column(name = "name")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)  /// проверяем есть ли PRIMARY KEY
    private  int id;
    @ManyToMany(fetch = FetchType.EAGER)//ДВЕ ТАБЛИЦЫ БУДУТ ОБЪЕДИНЕНЫ
    @JoinTable(name = "studentSkill",joinColumns = {@JoinColumn(name = "student_id",
            referencedColumnName = "student_id")},inverseJoinColumns = {@JoinColumn(name = "skill_id",
            referencedColumnName = "id")})//name our table

            Set<Skill> skills;
            Set<Student> students;

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Student() {

    }

    public Student(String name, String lastName, int id) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }
}