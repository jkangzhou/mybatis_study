package cn.zhou.mapper;

import cn.zhou.entity.PlayRecord;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (PlayRecord)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-19 13:49:46
 */
public interface PlayRecordMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PlayRecord queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param playRecord 查询条件
     * @param pageable   分页对象
     * @return 对象列表
     */
   // List<PlayRecord> queryAllByLimit(PlayRecord playRecord, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param playRecord 查询条件
     * @return 总行数
     */
    long count(PlayRecord playRecord);

    /**
     * 新增数据
     *
     * @param playRecord 实例对象
     * @return 影响行数
     */
    int insert(PlayRecord playRecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PlayRecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PlayRecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PlayRecord> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PlayRecord> entities);

    /**
     * 修改数据
     *
     * @param playRecord 实例对象
     * @return 影响行数
     */
    int update(PlayRecord playRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

