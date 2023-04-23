package cn.zhou.daoTest;

import cn.zhou.bean.User;
import cn.zhou.dao.UserMapper;
import cn.zhou.utils.MybatiesUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * The type User mapper test.
 */
public class UserMapperTest {

    @Test
    public void Test(){
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


}
