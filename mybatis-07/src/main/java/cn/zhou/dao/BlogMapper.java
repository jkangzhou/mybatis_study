package cn.zhou.dao;
import cn.zhou.bean.Blog;
import java.util.List;
import java.util.Map;

/**
 * The interface Blog mapper.
 */
public interface BlogMapper {

    /**
     * Add blog int.
     *新增一个博客
     * @param blog the blog
     * @return the int
     */
    int addBlog(Blog blog);

    /**
     * Query blog if list.
     *动态SQL
     * @param map the map
     * @return the list
     */
    List<Blog> queryBlogIf(Map map);

    List<Blog> queryBlogChoose(Map map);

    int updateBlog(Map map);

    List<Blog> queryBlogForeach(Map map);
}
