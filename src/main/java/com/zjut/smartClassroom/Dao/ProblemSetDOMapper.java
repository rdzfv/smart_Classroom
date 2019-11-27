package com.zjut.smartClassroom.Dao;

import com.zjut.smartClassroom.dataObject.ProblemSetDO;
import com.zjut.smartClassroom.dataObject.ProblemSetDOExample;
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

public interface ProblemSetDOMapper {
    @SelectProvider(type=ProblemSetDOSqlProvider.class, method="countByExample")
    long countByExample(ProblemSetDOExample example);

    @DeleteProvider(type=ProblemSetDOSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProblemSetDOExample example);

    @Delete({
        "delete from problem_set",
        "where problem_set_id = #{problemSetId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer problemSetId);

    @Insert({
        "insert into problem_set (problem_set_id, teacher_id, ",
        "course_id, problem_release_time, ",
        "paper_id, problem_set_name, ",
        "problem_set_detail, problem_set_picUrl)",
        "values (#{problemSetId,jdbcType=INTEGER}, #{teacherId,jdbcType=INTEGER}, ",
        "#{courseId,jdbcType=INTEGER}, #{problemReleaseTime,jdbcType=TIMESTAMP}, ",
        "#{paperId,jdbcType=INTEGER}, #{problemSetName,jdbcType=VARCHAR}, ",
        "#{problemSetDetail,jdbcType=VARCHAR}, #{problemSetPicurl,jdbcType=VARCHAR})"
    })
    int insert(ProblemSetDO record);

    @InsertProvider(type=ProblemSetDOSqlProvider.class, method="insertSelective")
    int insertSelective(ProblemSetDO record);

    @SelectProvider(type=ProblemSetDOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="problem_set_id", property="problemSetId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER),
        @Result(column="problem_release_time", property="problemReleaseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="paper_id", property="paperId", jdbcType=JdbcType.INTEGER),
        @Result(column="problem_set_name", property="problemSetName", jdbcType=JdbcType.VARCHAR),
        @Result(column="problem_set_detail", property="problemSetDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="problem_set_picUrl", property="problemSetPicurl", jdbcType=JdbcType.VARCHAR)
    })
    List<ProblemSetDO> selectByExample(ProblemSetDOExample example);

    @Select({
        "select",
        "problem_set_id, teacher_id, course_id, problem_release_time, paper_id, problem_set_name, ",
        "problem_set_detail, problem_set_picUrl",
        "from problem_set",
        "where problem_set_id = #{problemSetId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="problem_set_id", property="problemSetId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER),
        @Result(column="problem_release_time", property="problemReleaseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="paper_id", property="paperId", jdbcType=JdbcType.INTEGER),
        @Result(column="problem_set_name", property="problemSetName", jdbcType=JdbcType.VARCHAR),
        @Result(column="problem_set_detail", property="problemSetDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="problem_set_picUrl", property="problemSetPicurl", jdbcType=JdbcType.VARCHAR)
    })
    ProblemSetDO selectByPrimaryKey(Integer problemSetId);

    @UpdateProvider(type=ProblemSetDOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ProblemSetDO record, @Param("example") ProblemSetDOExample example);

    @UpdateProvider(type=ProblemSetDOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ProblemSetDO record, @Param("example") ProblemSetDOExample example);

    @UpdateProvider(type=ProblemSetDOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProblemSetDO record);

    @Update({
        "update problem_set",
        "set teacher_id = #{teacherId,jdbcType=INTEGER},",
          "course_id = #{courseId,jdbcType=INTEGER},",
          "problem_release_time = #{problemReleaseTime,jdbcType=TIMESTAMP},",
          "paper_id = #{paperId,jdbcType=INTEGER},",
          "problem_set_name = #{problemSetName,jdbcType=VARCHAR},",
          "problem_set_detail = #{problemSetDetail,jdbcType=VARCHAR},",
          "problem_set_picUrl = #{problemSetPicurl,jdbcType=VARCHAR}",
        "where problem_set_id = #{problemSetId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProblemSetDO record);
}