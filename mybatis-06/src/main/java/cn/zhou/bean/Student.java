package cn.zhou.bean;

import lombok.Data;

/**
 * 学生类bean
 * tid是外键
 * @author xxxx
 * @date 2020-05-09$
 */
@Data
public class Student {
    private int id;
    private String name;
    private int tid;
}
