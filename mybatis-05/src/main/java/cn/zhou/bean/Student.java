package cn.zhou.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 学生类bean
 * tid是外键
 * @author xxxx
 * @date 2020-05-09
 */
@Data
public class Student implements Serializable {
    private int id;
    private String name;
    private Teacher teacher;
}
