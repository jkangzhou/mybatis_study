package cn.zhou.utils;
import java.util.UUID;
public class IDUtils {
        public static String genId(){
            return UUID.randomUUID().toString().replaceAll("-","");
        }


}
