import cn.zhou.bean.Student;
import cn.zhou.dao.StudentMapper;
import cn.zhou.utils.MybatiesUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test(){
        SqlSession session = MybatiesUtils.getSqlSessionFactor();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudent();
        for (Student student : students) {
            System.out.println(student);
        }
        session.close();
    }

//    配置了懒加载  需要的时候才查 节省资源
    @org.junit.Test
    public void testgetStudentList(){
        SqlSession session = MybatiesUtils.getSqlSessionFactor();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student students = mapper.getStudentList(2);
        //System.out.println(students.getName());
        System.out.println(students.getTeacher().getName());
        session.close();
    }

    @org.junit.Test
    public void test2(){
        SqlSession session = MybatiesUtils.getSqlSessionFactor();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.getST();
        for (Student student : students) {
            System.out.println(student);
        }
        session.close();
    }
}
