package ua.bibliy.Dao.Jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.bibliy.Dao.Jdbc.JdbcStudentDao;
import ua.bibliy.Model.Student;
import ua.bibliy.Util.ConnectionJDBC;
import ua.bibliy.Util.StudentMapper;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

@Component
public class JdbcStudentDAOImpl  implements JdbcStudentDao {

     private DataSource dataSource;
     private JdbcTemplate jdbcTemplate;

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public void add(Student student) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = ConnectionJDBC.getPreparedStatement("INSERT INTO student(name,lastName)" +
                " VALUES (?, ?)");
        statement.setString(1,student.getName());
        statement.setString(1,student.getLastName());
        statement.executeUpdate();
    }

    @Override
    public void update(Student student) {
        jdbcTemplate.update("UPDATE STUDENTS SET name = ?,lastName = ? WHERE id = ?"
        ,student.getName(),student.getLastName(),student.getId());

    }

    @Override
    public List<Student> list() {

        List<Student>students = jdbcTemplate.query("SELECT* FROM student",new StudentMapper());

   return students; }

    @Override
    public Student getById(Integer id) {
        Student student = (Student)jdbcTemplate.queryForObject("SELECT * FROM student WHERE id = ?", new Object[]{id},new StudentMapper());
        return student;
    }

    @Override
    public void remove(Integer id) {
        jdbcTemplate.update("DELETE FROM student WHERE id = ?",id);

    }
}