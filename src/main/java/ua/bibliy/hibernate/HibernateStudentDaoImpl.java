package ua.bibliy.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.bibliy.Model.Student;

import java.sql.SQLException;
import java.util.List;

public class HibernateStudentDaoImpl implements HibernateStudentDao {

    SessionFactory sessionFactory;
    @Override
    public void add(Student student) throws SQLException, ClassNotFoundException {
        Session session = this.sessionFactory.openSession();
         session.save(student);
    }

    @Override
    public void update(Student student) {

        Session session = this.sessionFactory.openSession();
        session.update(student);
    }

    @Override
    public List<Student> list() {

        Session session = this.sessionFactory.openSession();
      List students = session.createQuery("from ua.bibliy.Model.Student").list();
        return students;
    }

    @Override
    public Student getById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = session.load(Student.class,id);
        return student;
    }

    @Override
    public void remove(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = session.load(Student.class,id);

        if (student!= null){
            session.delete(student);
        }

    }
}
