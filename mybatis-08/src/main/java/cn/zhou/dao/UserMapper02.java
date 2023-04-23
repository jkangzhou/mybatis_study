package cn.zhou.dao;

import cn.zhou.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * The interface Blog mapper.
 */
public interface UserMapper02 {

    List<User> getUser();

    User getUserById(@Param("id") int id);
}
