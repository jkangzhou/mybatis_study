package cn.zhou.mapper;

import cn.zhou.entity.Chapter;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ChapterMapper {
    List<Chapter> listChapter();

}
