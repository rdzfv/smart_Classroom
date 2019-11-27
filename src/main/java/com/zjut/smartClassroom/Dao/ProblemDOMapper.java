package com.zjut.smartClassroom.Dao;

import com.zjut.smartClassroom.dataObject.ProblemDO;
import com.zjut.smartClassroom.dataObject.ProblemDOExample;
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

public interface ProblemDOMapper {
    @SelectProvider(type=ProblemDOSqlProvider.class, method="countByExample")
    long countByExample(ProblemDOExample example);

    @DeleteProvider(type=ProblemDOSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProblemDOExample example);

    @Delete({
        "delete from problem",
        "where problem_id = #{problemId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer problemId);

    @Insert({
        "insert into problem (problem_id, problem_information, ",
        "problem_choices, problem_explain, ",
        "problem_ans)",
        "values (#{problemId,jdbcType=INTEGER}, #{problemInformation,jdbcType=VARCHAR}, ",
        "#{problemChoices,jdbcType=VARCHAR}, #{problemExplain,jdbcType=VARCHAR}, ",
        "#{problemAns,jdbcType=INTEGER})"
    })
    int insert(ProblemDO record);

    @InsertProvider(type=ProblemDOSqlProvider.class, method="insertSelective")
    int insertSelective(ProblemDO record);

    @SelectProvider(type=ProblemDOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="problem_id", property="problemId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="problem_information", property="problemInformation", jdbcType=JdbcType.VARCHAR),
        @Result(column="problem_choices", property="problemChoices", jdbcType=JdbcType.VARCHAR),
        @Result(column="problem_explain", property="problemExplain", jdbcType=JdbcType.VARCHAR),
        @Result(column="problem_ans", property="problemAns", jdbcType=JdbcType.INTEGER)
    })
    List<ProblemDO> selectByExample(ProblemDOExample example);

    @Select({
        "select",
        "problem_id, problem_information, problem_choices, problem_explain, problem_ans",
        "from problem",
        "where problem_id = #{problemId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="problem_id", property="problemId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="problem_information", property="problemInformation", jdbcType=JdbcType.VARCHAR),
        @Result(column="problem_choices", property="problemChoices", jdbcType=JdbcType.VARCHAR),
        @Result(column="problem_explain", property="problemExplain", jdbcType=JdbcType.VARCHAR),
        @Result(column="problem_ans", property="problemAns", jdbcType=JdbcType.INTEGER)
    })
    ProblemDO selectByPrimaryKey(Integer problemId);

    @UpdateProvider(type=ProblemDOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ProblemDO record, @Param("example") ProblemDOExample example);

    @UpdateProvider(type=ProblemDOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ProblemDO record, @Param("example") ProblemDOExample example);

    @UpdateProvider(type=ProblemDOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProblemDO record);

    @Update({
        "update problem",
        "set problem_information = #{problemInformation,jdbcType=VARCHAR},",
          "problem_choices = #{problemChoices,jdbcType=VARCHAR},",
          "problem_explain = #{problemExplain,jdbcType=VARCHAR},",
          "problem_ans = #{problemAns,jdbcType=INTEGER}",
        "where problem_id = #{problemId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProblemDO record);
}