import javax.xml.transform.Result;
import java.sql.*;
import java.util.ResourceBundle;

public class DBUtils {
    private DBUtils() {
    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String url = rb.getString("url");
        String username = rb.getString("username");
        String password = rb.getString("password");
        return DriverManager.getConnection(url, username, password);

    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
