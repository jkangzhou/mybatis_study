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
     * 分页查询
     * @param map
     * @return
     */
    List<User> getLimit(Map<String,Integer> map);

}
