package cn.zhou.dao;

import cn.zhou.bean.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {

    @Select("select * from teacher where id=#{id}")
    Student getStudent(@Param("id") int id);
}
