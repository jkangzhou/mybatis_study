package cn.zhou.dao;
import cn.zhou.bean.User;

import java.security.Key;
import java.util.List;
import java.util.Map;

/**
 * The interface User dao.
 */
public interface UserDao {

    /**
     * Select user list.
     * 查询用户
     * @return the list
     */
    List<User> selectUser();


    /**
     * Gets user by id.
     * 根据id查询用户
     * @param id the id
     * @return the user by id
     */
    User getUserById(int id);


    /**
     * Gets user by like.
     * 模糊查询
     * @param value the value
     * @return the user by like
     */
    List<User> getUserByLike(String value);


    /**
     * Insert int.
     * 插入一条记录
     * @param user the user
     * @return the int
     */
    int insert(User user);


    /**
     * Insert map int.
     * 插入一条记录
     * @param map the map
     * @return the int
     */
    int insertMap(Map<String,Object> map);

    /**
     * Update int.
     * 更新一条记录
     * @param user the user
     * @return the int
     */
    int update(User user);

    /**
     * Delete int.
     * 删除一条记录
     * @param id the id
     * @return the int
     */
    int delete(int id);

}
