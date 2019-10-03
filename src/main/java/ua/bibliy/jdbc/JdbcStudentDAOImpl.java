package ua.bibliy.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.bibliy.Model.Student;
import ua.bibliy.Util.StudentMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Component
public class JdbcStudentDAOImpl implements JdbcStudentDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public JdbcStudentDAOImpl() {

    }

    public DataSource getDataSource() {
        return dataSource;
    }
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcStudentDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(Student student) throws SQLException, ClassNotFoundException {

        jdbcTemplate.update("INSERT INTO student (name, last_name)VALUES (?, ?) "
                ,student.getName(), student.getLastName() );




//            PreparedStatement statement = ConnectionJDBC.getPreparedStatement(
//                    "INSERT INTO student (name, last_name)" +
//                            " VALUES (?, ?) ");
//            statement.setString(1, student.getName());
//            statement.setString(2, student.getLastName());
//            statement.executeUpdate();
    }

    @Override
    public void update(Student student) {
        jdbcTemplate.update("UPDATE STUDENTS SET name = ?,lastName = ? WHERE  id = ?"
                ,student.getName(),student.getLastName(),student.getId());
    }

    @Override
    public List<Student> list() {
        List<Student>students = jdbcTemplate.query("SELECT* FROM student", new StudentMapper());

        return students;
    }

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
