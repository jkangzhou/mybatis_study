package cn.zhou.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class User implements Serializable {
    private int id;
    private String name;
    private String email;
    private Date date;
}
