

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Driver;
import java.sql.Connection;
import java.sql.Statement;

public class JDBCTest {

    public static void main(String[] args)  {
        /**
         * 1、注册驱动
         * 2、获取连接
         * 3、获取数据库操作对象
         * 4、执行sql
         * 5、处理结果集
         * 6、关闭资源
         *
         * */
        Statement statement=null;
        ResultSet resultSet=null;
        Connection conn=null;
        try{
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring6");
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            String url="jdbc:mysql://localhost:3306/spring6?useSSL=false";
            String user="root";
            String password="123456";
            conn = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println(conn);
            statement = (Statement) conn.createStatement();
            String sql="select actno, balance from t_act";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String actno = resultSet.getString("actno");
                Double balance=resultSet.getDouble("balance");
                System.out.println(actno+","+balance);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(resultSet !=null){
                try{
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(statement != null){
                try {
                    statement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(conn !=null){
                try {
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }


        }



    }
}
