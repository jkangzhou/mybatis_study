package cn.zhou.bean;
import lombok.Data;

import java.util.List;

/**
 * 老师类bean
 *
 * @author xxxx
 * @date 2020-05-09$
 */
@Data
public class Teacher {
    private int id;
    private String name;
    //添加学生集合
    private List<Student> students;
}
