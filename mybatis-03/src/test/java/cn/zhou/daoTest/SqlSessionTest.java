package cn.zhou.daoTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionTest {
    public static InputStream inputStream;
    public static SqlSessionFactory sqlSessionFactory;
    static {
        try {//实验
            String resource = "mybatis-config.xml";
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void getSqlSessionFactory() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Object o = sqlSession.selectOne("cn.zhou.dao.UserMapper.getUserById", 1);
        System.out.println(o);
        sqlSession.close();
    }
}
