import cn.zhou.bean.Blog;
import cn.zhou.dao.BlogMapper;
import cn.zhou.utils.IDUtil;
import cn.zhou.utils.MybatiesUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class test {
    @Test
    public void addInitBlog(){
        SqlSession session = MybatiesUtils.getSqlSessionFactor();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtil.genId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        session.close();
    }
    @Test
    public void testQueryBlogIf(){
        SqlSession session = MybatiesUtils.getSqlSessionFactor();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap<String, String> map = new HashMap<String, String>();
        //map.put("title","Mybatis如此简单");
        map.put("author","狂神说");
        List<Blog> blogs = mapper.queryBlogIf(map);
        System.out.println(blogs);
        session.close();
    }
    @Test
    public void testQueryBlogChoose(){
        SqlSession session = MybatiesUtils.getSqlSessionFactor();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        //map.put("title","Mybatis如此简单");
       // map.put("author","狂神说");
        //map.put("views",9999);
        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        session.close();
    }
    @Test
    public void testUpdateBlog(){
        SqlSession session = MybatiesUtils.getSqlSessionFactor();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title","Mybatis修改");
        map.put("author","周进康");
        map.put("id","a0d5c59a8030413f97353a28207ae20f");

        mapper.updateBlog(map);


        session.close();
    }
    @Test
    public void testqueryBlogForeach(){
        SqlSession session = MybatiesUtils.getSqlSessionFactor();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        List<Integer> ids = new ArrayList();
        map.put("ids",ids);
        ids.add(1);
        ids.add(2);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        session.close();
    }
}
