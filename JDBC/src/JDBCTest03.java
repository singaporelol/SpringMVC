import java.sql.*;

public class JDBCTest03 {

  public static void main(String[] args) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      // 注册驱动
      Class.forName("com.mysql.jdbc.Driver");

      conn = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/spring6?",
          "root",
          "123456"
        );
      //            PreparedStatement ps = conn.prepareStatement("insert into t_act (actno, balance) values(?,?)");
      //            ps.setString(1,"act-003");
      //            ps.setDouble(2,88888);
      //            ps.executeUpdate();
      ps = conn.prepareStatement("select actno, balance from t_act where actno=?");
      ps.setString(1, "act-001");
      rs = ps.executeQuery();
      while (rs.next()) {
        String actno = rs.getString("actno");
        double balance = rs.getDouble("balance");

        System.out.println(actno + ", " + balance);
      }
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      // 6、关闭资源
      // 需要从小到大关闭
      try {
        if (rs != null) {
          rs.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      try {
        if (ps != null) {
          ps.close();
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
