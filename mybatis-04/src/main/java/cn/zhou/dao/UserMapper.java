package cn.zhou.dao;

import cn.zhou.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * The interface User mapper.
 * @author 1
 */
public interface UserMapper {

    /**
     * Gets user.
     * 使用@Results（@Result（））  可以解决映射问题
     * 可以编写一个主结果集  命名id 后面用@ResultMap(value = "UserMap")
     * 此处，@Results注解表示属性信息为一个resultMap，id则是命名空间内识别该resultMap的唯一标识，column和property及其其他属性与在resultMap标签内定义方式相同。
     *
     * 此处的定义，@Results注解必须与@Select查询同方法在一起，不可以单独定义@Results注解，会不被识别的。定义后，在其他方法处，便可以使用该@Results定义的resultMap了。
     * @return the user
     */
    @Results(id = "UserMap",value = {
            @Result(column="email",property="mail")})
    @Select("select * from user")
    List<User> getUser();

    /**
     * 此处@Param("id")  id与id=#{id} 参数必须相同  若有多个参数则每个参数都要加@Param( )
     *
     * @param id the id
     * @return the user
     */
    @ResultMap(value = "UserMap")
    @Select("select * from user where id=#{id}")
    User selectUser(@Param("id") int id);

    /**
     * Add user int.
     * 引用类型不用写@Param( )
     *
     * @param user the user
     * @return the int
     */
    @Insert("insert into user values (#{id},#{name},#{email},#{date})")
    int addUser(User user);

    /**
     * Sel like list.
     *
     * @param value the value
     * @return the list
     */
    @ResultMap(value = "UserMap")
    @Select({"select * from user where name like #{value}"})
    List<User> selLike(String value);
}
