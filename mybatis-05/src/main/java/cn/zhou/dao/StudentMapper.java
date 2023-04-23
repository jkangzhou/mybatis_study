package cn.zhou.dao;

import cn.zhou.bean.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    List<Student> getStudent();

    Student getStudentList(int id);

    List<Student> getST();
}
