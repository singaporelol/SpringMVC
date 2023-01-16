import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest04 {

    //封装Connection对象+事务的处理
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
             conn = DBUtils.getConnection();

            //JDBC默认是，执行execute,自动提交事务。
            //不方便控制事务
            // 这个行代码，设置取消自动提交
            conn.setAutoCommit(false);
            String sql = "update t_act set balance=balance-10000 where actno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "act-001");
            int count = ps.executeUpdate();
            String s = null;
            s.toString();
            ps = conn.prepareStatement("update t_act set balance=balance+10000 where actno=?");
            ps.setString(1, "act-002");
            count+=ps.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            try {
                if (conn != null) {
                  // 发生异常回滚事务
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DBUtils.close(conn, ps, null);
        }

    }
}
