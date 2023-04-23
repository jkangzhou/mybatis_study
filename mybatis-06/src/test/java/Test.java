import cn.zhou.bean.Student;
import cn.zhou.bean.Teacher;
import cn.zhou.dao.TeacherMapper;
import cn.zhou.utils.MybatiesUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test(){
        SqlSession session = MybatiesUtils.getSqlSessionFactor();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        List<Teacher> ts = mapper.getTS(1);
        for (Teacher t : ts) {
            System.out.println(t);
        }
        session.close();
    }
    @org.junit.Test
    public void test2(){
        SqlSession session = MybatiesUtils.getSqlSessionFactor();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        List<Teacher> ts = mapper.getTS2(1);
        for (Teacher t : ts) {
            System.out.println(t);
        }
        session.close();
    }
/**
 * Teacher(id=0, name=秦老师, students=
 * [Student(id=1, name=小明, tid=1),
 * Student(id=2, name=小红, tid=1),
 * Student(id=3, name=小张, tid=1),
 * Student(id=4, name=小李, tid=1),
 * Student(id=5, name=小王, tid=1)])
 */
}
