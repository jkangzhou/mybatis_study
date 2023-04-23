package cn.zhou.dao;

import cn.zhou.bean.Student;
import cn.zhou.bean.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    //获取老师
    List<Teacher> getTeacher();

    //获取指定老师的所有学生
    List<Teacher> getTS(@Param("tid") int id);

    //获取指定老师的所有学生
    List<Teacher> getTS2(@Param("tid") int id);
}
