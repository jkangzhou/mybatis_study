import cn.zhou.mapper.ChapterMapper;
import cn.zhou.entity.Chapter;
import cn.zhou.utils.MybatiesUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest{
    @Test
    public void test01(){

        SqlSession sqlSessionFactor = MybatiesUtils.getSqlSessionFactor();
        ChapterMapper mapper = sqlSessionFactor.getMapper(ChapterMapper.class);
        List<Chapter> chapters = mapper.listChapter();
        for (Chapter chapter: chapters) {
            System.out.println(chapter);
        }
        //        List<Chapter> chapters = mapper.listChapter();
//        for (Chapter chapter: chapters) {
//            System.out.println(chapter);
//        }
//        sqlSessionFactor.close();


    }

}
