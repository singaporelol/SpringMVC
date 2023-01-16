import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisIntroductionTest {
    public static void main(String[] args) throws IOException {
        // 从XML中构建SqlSessionFactory
        //在MyBatis中，负责执行SQL语句的对象：
        // SqlSession
        // SqlSession是专门用来执行SQL语句的，是java程序和数据库之间的一次会话。
        // 想要获取SQLSession对象，需要先获取SqlSessionFactory对象，通过SqlSessionFactory工厂来生产SqlSession对象。
        // 如何获取SqlSessionFactory对象？
        // 获取SqlSessionFactoryBuilder对象
        // 通过SqlSessionFactoryBuilder对象的build方法，来获取一个SqlSessionFactory对象。

        // mybatis的核心对象包括：
        // SqlSessionFactoryBuilder
        // SqlSessionFactory
        // SqlSession
        // SqlSessionFactoryBuilder-->SqlSessionFactory-->SqlSession

        // 1、创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int count=sqlSession.insert("insertCar");
        System.out.println(count);
        sqlSession.commit();


    }
}
