package ua.bibliy.Util;

import ua.bibliy.Model.Student;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int id) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setLastName(rs.getString("lastName"));
        return student;
    }


}
