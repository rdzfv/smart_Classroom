package com.zjut.smartClassroom.Dao;

import com.zjut.smartClassroom.dataObject.PaperDO;
import com.zjut.smartClassroom.dataObject.PaperDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PaperDOMapper {
    @SelectProvider(type=PaperDOSqlProvider.class, method="countByExample")
    long countByExample(PaperDOExample example);

    @DeleteProvider(type=PaperDOSqlProvider.class, method="deleteByExample")
    int deleteByExample(PaperDOExample example);

    @Delete({
        "delete from paper",
        "where paper_id = #{paperId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer paperId);

    @Insert({
        "insert into paper (paper_id, problem_set_id, ",
        "problem_id)",
        "values (#{paperId,jdbcType=INTEGER}, #{problemSetId,jdbcType=INTEGER}, ",
        "#{problemId,jdbcType=INTEGER})"
    })
    int insert(PaperDO record);

    @InsertProvider(type=PaperDOSqlProvider.class, method="insertSelective")
    int insertSelective(PaperDO record);

    @SelectProvider(type=PaperDOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="paper_id", property="paperId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="problem_set_id", property="problemSetId", jdbcType=JdbcType.INTEGER),
        @Result(column="problem_id", property="problemId", jdbcType=JdbcType.INTEGER)
    })
    List<PaperDO> selectByExample(PaperDOExample example);

    @Select({
        "select",
        "paper_id, problem_set_id, problem_id",
        "from paper",
        "where paper_id = #{paperId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="paper_id", property="paperId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="problem_set_id", property="problemSetId", jdbcType=JdbcType.INTEGER),
        @Result(column="problem_id", property="problemId", jdbcType=JdbcType.INTEGER)
    })
    PaperDO selectByPrimaryKey(Integer paperId);

    @UpdateProvider(type=PaperDOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PaperDO record, @Param("example") PaperDOExample example);

    @UpdateProvider(type=PaperDOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PaperDO record, @Param("example") PaperDOExample example);

    @UpdateProvider(type=PaperDOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PaperDO record);

    @Update({
        "update paper",
        "set problem_set_id = #{problemSetId,jdbcType=INTEGER},",
          "problem_id = #{problemId,jdbcType=INTEGER}",
        "where paper_id = #{paperId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PaperDO record);
}