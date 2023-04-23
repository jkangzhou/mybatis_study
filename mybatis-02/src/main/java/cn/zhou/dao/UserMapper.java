package cn.zhou.dao;
import cn.zhou.bean.User;

import java.util.List;
import java.util.Map;

/**
 * The interface User mapper.
 */
public interface UserMapper {


    /**
     * Select user list.
     *
     * @return the list
     */
    List<User> selectUser();

    /***
     * 根据id查询用户
     * @param id the id
     * @return user by id
     */
    User getUserById(int id);

    /***
     * 插入一条记录
     * @param user the user
     * @return int int
     */
    int insert(User user);


    /***
     * 更新一条记录
     * @param user the user
     * @return int int
     */
    int update(User user);

    /***
     * 删除一条记录
     * @param id the id
     * @return int int
     */
    int delete(int id);

    int ceshi();

}
