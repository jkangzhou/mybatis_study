package cn.zhou.userMapperTest;

import cn.zhou.bean.User;
import cn.zhou.dao.UserMapper;
import cn.zhou.utils.MybatiesUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

/**
 * TODO:
 *
 * @author xxxx
 * @date 2020-05-09
 */
public class test {
    @Test
    public void getUserTest(){
        SqlSession session = MybatiesUtils.getSqlSessionFactor();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.getUser();
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
    }
    @Test
    public void selectUserTest(){
        SqlSession session = MybatiesUtils.getSqlSessionFactor();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUser(4);
        System.out.println(user);
        session.close();
    }
    @Test
    public void addUserTest(){
        SqlSession session = MybatiesUtils.getSqlSessionFactor();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int user = mapper.addUser(new User(9, "老叶", "laoye@123.com", new Date(829735988L)));
        if (user>0) {
            System.out.println("插入成功!");
        }
        //在工具类中已设置自动提交事务
        session.close();
    }
    @Test
    public void selLikeTest(){
        SqlSession session = MybatiesUtils.getSqlSessionFactor();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selLike("%老%");
        for (User user : users) {
            System.out.println(user);
        }
        //在工具类中已设置自动提交事务
        session.close();
    }
}
