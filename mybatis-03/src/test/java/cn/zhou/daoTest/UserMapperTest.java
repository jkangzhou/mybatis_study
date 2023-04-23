package cn.zhou.daoTest;

import cn.zhou.bean.User;
import cn.zhou.dao.UserMapper;
import cn.zhou.utils.MybatiesUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * The type User mapper test.
 */
public class UserMapperTest {

    /**
     *1.导包 不要导错import org.apache.log4j.Logger;
     * 加载对象 要获取当前类的class
     */
    static Logger logger = Logger.getLogger(UserMapperTest.class);


    @Test
    public void userByIdTest(){
        logger.info("info:进入了userByIdTest");
        logger.debug("debug:进入了userByIdTest");
        logger.error("error:进入了userByIdTest");
        SqlSession session = null;
        try {
            session = MybatiesUtils.getSqlSessionFactor();
            UserMapper mapper = session.getMapper(UserMapper.class);
            User userById = mapper.getUserById(4);
            System.out.println(userById);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
    @Test
    public void selectUserTest(){

        SqlSession session = null;
        try {
            session = MybatiesUtils.getSqlSessionFactor();
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> users = mapper.selectUser();
            for (User user : users) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Test
    public void getLimitTest(){
        SqlSession session = MybatiesUtils.getSqlSessionFactor();
        UserMapper mapper = session.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",0);
        map.put("endIndex",6);
        List<User> limit = mapper.getLimit(map);
        for (User user : limit) {
            System.out.println(user);
        }

        session.close();
    }
}
