package cn.zhou.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chapter {
    private Integer id;
    private Integer videoId;
    private String title;
    private  Integer ordered;
    private Date createTime;
}
