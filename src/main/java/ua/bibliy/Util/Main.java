package ua.bibliy.Util;

import ua.bibliy.Model.Skill;
import ua.bibliy.Model.Student;
import ua.bibliy.repository.SkillRepository;
import ua.bibliy.repository.StudentRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");

        SkillRepository skillRepository = context.getBean(SkillRepository.class);
        StudentRepository studentRepository = context.getBean(StudentRepository.class);

        Skill skill = new Skill();
        skill.setName("java");

        Student student = new Student();
        student.setName("Jon");

        Set<Skill> skills = new HashSet<>();
        skills.add(skill);

        Set<Student> students = new HashSet<>();
        students.add(student);

        student.setSkills(skills);
        skill.setStudentSet(students);


        skillRepository.save(skill);
        studentRepository.save(student);
    }
}