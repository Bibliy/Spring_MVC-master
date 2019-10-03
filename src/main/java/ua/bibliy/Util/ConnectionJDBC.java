package ua.bibliy.Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionJDBC {
    public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException {

        PreparedStatement result = null;

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/students" +
                "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String pass = " ";

        Connection connection = DriverManager.getConnection(url, user, pass);
        result =  connection.prepareStatement(sql);

        return result;
    }
}