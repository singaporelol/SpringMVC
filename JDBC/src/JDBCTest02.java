import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class JDBCTest02 {

  public static void main(String[] args) {
    Connection conn = null;
    Statement statement = null;
    ResultSet resultSet = null;
    try {
      // 1、注册驱动(2种方式)
      //第一种方式：
      // Driver driver = new com.mysql.jdbc.Driver();
      // DriverManager.registerDriver(driver);
      //第二种方式：
      Class.forName("com.mysql.jdbc.Driver");
      //从property文件获取配置
      ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
      String url = bundle.getString("url");
      String username = bundle.getString("username");
      String password = bundle.getString("password");
      //2、获取连接对象
      conn = DriverManager.getConnection(url, username, password);
      //3、获取操作数据库对象statement
      statement = conn.createStatement();
      // 4、准备sql
      String sql = "select actno,balance from t_act";
      //5、获取结果集
      resultSet = statement.executeQuery(sql);

      while (resultSet.next()) {
        String actno = resultSet.getString("actno");
        Double balance = resultSet.getDouble("balance");
        System.out.println(actno + " ," + balance);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    } finally {
      // 6、关闭资源
      // 需要从小到大关闭
      try {
        if (resultSet != null) {
          resultSet.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      try {
        if (statement != null) {
          statement.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      try {
        if (conn != null) {
          conn.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
