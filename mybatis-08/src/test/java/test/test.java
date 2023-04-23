package test;

import cn.zhou.bean.User;
import cn.zhou.dao.UserMapper02;
import cn.zhou.utils.MybatiesUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class test {
    @Test
    public void getUserTest(){
        SqlSession session = MybatiesUtils.getSqlSessionFactor();
        UserMapper02 mapper = session.getMapper(UserMapper02.class);
        List<User> user = mapper.getUser();
        for (User users : user) {
            System.out.println(users);
        }
        session.close();
    }

    /***
     * 两级缓存:
     * 一级缓存: (本地缓存) : sqlSession级别的缓存。一级缓存是一直开启的;
     *      与数据库同一次会话期间查询到的数据会放在本地缓存中。I
     *      以后如果需要获取相同的数据，直接从缓存中拿，没必要再去查询数据库;
     * 一级缓存失效情况(没有使用到当前一级缓存的情况，效果就是，还需要再向数据库发出查询) :
     *      1、sqlSession不同。
     *      2、sqlSession相同，查询条件不同。(当前一-级缓存中还没有这个数据)
     *      3、sqlSession相同，两次查询之间执行了增删改操作(这次增删改可能对当前数据有影响)
     *       4、sqlSession相同，手动清除了一级缓存(缓存清空)
     * 二级缓存: (全局缓存)
     *
     * 一级缓存默认开启 可手动清除缓存session.clearCache();
     * 在查询操作时不会清空缓存
     * 在增删改中会刷新缓存
     */
    @Test
    public void getUserById1Test(){
        SqlSession session = MybatiesUtils.getSqlSessionFactor();
        UserMapper02 mapper = session.getMapper(UserMapper02.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        //手动清除缓存
        //session.clearCache();
        System.out.println("===================================");
        User userById2 = mapper.getUserById(1);
        System.out.println(userById==userById2);
        session.close();
    }

    /***
     * 二级缓存也叫全局缓存，一级缓存作用域太低了，所以诞生了二级缓存
     * 基于namespace级别的缓存，一个名称空间，对应一个二级缓存；
     * 工作机制
     * 一个会话查询一条数据，这个数据就会被放在当前会话的一级缓存中；
     * 如果当前会话关闭了，这个会话对应的一级缓存就没了；但是我们想要的是，会话关闭了，一级缓存中的数据被保存到二级缓存中；
     * 新的会话查询信息，就可以从二级缓存中获取内容；
     * 不同的mapper查出的数据会放在自己对应的缓存（map）中；
     */
    @Test
    public void getUserById2Test(){
        SqlSession session = MybatiesUtils.getSqlSessionFactor();
        UserMapper02 mapper = session.getMapper(UserMapper02.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        session.close();
        //session.clearCache();
        System.out.println("===================================");
        SqlSession session2 = MybatiesUtils.getSqlSessionFactor();
        UserMapper02 mapper2 = session2.getMapper(UserMapper02.class);
        User userById2 = mapper2.getUserById(1);
        System.out.println(userById2);
        System.out.println(userById==userById2);
        session2.close();
    }
}
