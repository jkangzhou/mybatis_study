package cn.zhou.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Alias("User")
public class User {
    private int id;
    private String name;
    private String email;
    private Date date;
}
