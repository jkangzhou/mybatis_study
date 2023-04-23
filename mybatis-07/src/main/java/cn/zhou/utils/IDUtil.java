package cn.zhou.utils;

import java.util.UUID;

public class IDUtil {
        public static String genId(){
           return UUID.randomUUID().toString().replaceAll("-","");
        }
}
