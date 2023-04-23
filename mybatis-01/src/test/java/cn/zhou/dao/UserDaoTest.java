package cn.zhou.dao;

import cn.zhou.bean.User;
import cn.zhou.utils.MybatiesUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public class UserDaoTest {

//    @Test
//    public void test01(){
//        SqlSession sqlSessionFactor = MybatiesUtils.getSqlSessionFactor();
//        List<User> list = sqlSessionFactor.selectList("UserDao.list"); //这里写死了 而且还得看id
//        for (User user: list) {
//            System.out.println(user);
//        }
//    }
    @Test
    public void Test(){
        SqlSession session = null;
        try {
            session = MybatiesUtils.getSqlSessionFactor();
            UserDao mapper = session.getMapper(UserDao.class);
            List<User> users = mapper.selectUser();
            for (User user : users) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert session != null;
            session.close();
        }
    }

    @Test
    public void getUserByIdTest(){
        SqlSession session = null;
        try {
            session = MybatiesUtils.getSqlSessionFactor();
            UserDao mapper = session.getMapper(UserDao.class);
            User userById = mapper.getUserById(3);
            System.out.println(userById);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert session != null;
            session.close();
        }

    }
    @Test
    public void getUserByLikeTest(){
        SqlSession session = null;
        try {
            session = MybatiesUtils.getSqlSessionFactor();
            UserDao mapper = session.getMapper(UserDao.class);
            List<User> user = mapper.getUserByLike("老");
            user.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert session != null;
            session.close();
        }
    }
    @Test
    public void insertTest(){
        SqlSession session = null;
        try {
        session = MybatiesUtils.getSqlSessionFactor();
        UserDao mapper = session.getMapper(UserDao.class);
        int i = mapper.insert(new User(9, "高晓松", "gaixiaosong@123.com", new Date(82236L)));
        if (i >0) {
            System.out.println("插入成功！");
        }
        //提交事务
        session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert session != null;
            session.close();
        }
    }
    @Test
    public void insertMapTest(){
        SqlSession session = null;
        try {
            session = MybatiesUtils.getSqlSessionFactor();
            UserDao mapper = session.getMapper(UserDao.class);
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("userid",9);
            map.put("username","老叶");
            map.put("useremail","laoye@123.com");
            map.put("userid",new Date(39480792837L));
            //提交事务
            int i = mapper.insertMap(map);
            if (i>0) {
                System.out.println("插入成功！");
            }
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert session != null;
            session.close();
        }
    }
    @Test
    public void updateTest(){
        SqlSession session = null;
        try {
            session = MybatiesUtils.getSqlSessionFactor();
            UserDao mapper = session.getMapper(UserDao.class);
            int update = mapper.update(new User(8,"王龙","wanglon@123.com",new Date(1238798764812L)));
            if (update>0) {
                System.out.println("修改成功");
            }
            //提交事务
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert session != null;
            session.close();
        }
    }
    @Test
    public void deleteTest(){
        SqlSession session = null;
        try {
            session = MybatiesUtils.getSqlSessionFactor();
            UserDao mapper = session.getMapper(UserDao.class);
            int delete = mapper.delete(9);
            if(delete>0){
                System.out.println("删除成功");
            }
            //提交事务
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert session != null;
            session.close();
        }
    }
}
