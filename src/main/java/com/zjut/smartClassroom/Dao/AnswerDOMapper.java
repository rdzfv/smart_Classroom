package com.zjut.smartClassroom.Dao;

import com.zjut.smartClassroom.dataObject.AnswerDO;
import com.zjut.smartClassroom.dataObject.AnswerDOExample;
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

public interface AnswerDOMapper {
    @SelectProvider(type=AnswerDOSqlProvider.class, method="countByExample")
    long countByExample(AnswerDOExample example);

    @DeleteProvider(type=AnswerDOSqlProvider.class, method="deleteByExample")
    int deleteByExample(AnswerDOExample example);

    @Delete({
        "delete from answer",
        "where ans_id = #{ansId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer ansId);

    @Insert({
        "insert into answer (ans_id, student_id, ",
        "problem_set_id, problem_id, ",
        "student_ans, istrue, ",
        "right_ans)",
        "values (#{ansId,jdbcType=INTEGER}, #{studentId,jdbcType=INTEGER}, ",
        "#{problemSetId,jdbcType=INTEGER}, #{problemId,jdbcType=INTEGER}, ",
        "#{studentAns,jdbcType=TINYINT}, #{istrue,jdbcType=TINYINT}, ",
        "#{rightAns,jdbcType=TINYINT})"
    })
    int insert(AnswerDO record);

    @InsertProvider(type=AnswerDOSqlProvider.class, method="insertSelective")
    int insertSelective(AnswerDO record);

    @SelectProvider(type=AnswerDOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="ans_id", property="ansId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.INTEGER),
        @Result(column="problem_set_id", property="problemSetId", jdbcType=JdbcType.INTEGER),
        @Result(column="problem_id", property="problemId", jdbcType=JdbcType.INTEGER),
        @Result(column="student_ans", property="studentAns", jdbcType=JdbcType.TINYINT),
        @Result(column="istrue", property="istrue", jdbcType=JdbcType.TINYINT),
        @Result(column="right_ans", property="rightAns", jdbcType=JdbcType.TINYINT)
    })
    List<AnswerDO> selectByExample(AnswerDOExample example);

    @Select({
        "select",
        "ans_id, student_id, problem_set_id, problem_id, student_ans, istrue, right_ans",
        "from answer",
        "where ans_id = #{ansId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ans_id", property="ansId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.INTEGER),
        @Result(column="problem_set_id", property="problemSetId", jdbcType=JdbcType.INTEGER),
        @Result(column="problem_id", property="problemId", jdbcType=JdbcType.INTEGER),
        @Result(column="student_ans", property="studentAns", jdbcType=JdbcType.TINYINT),
        @Result(column="istrue", property="istrue", jdbcType=JdbcType.TINYINT),
        @Result(column="right_ans", property="rightAns", jdbcType=JdbcType.TINYINT)
    })
    AnswerDO selectByPrimaryKey(Integer ansId);

    @UpdateProvider(type=AnswerDOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AnswerDO record, @Param("example") AnswerDOExample example);

    @UpdateProvider(type=AnswerDOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AnswerDO record, @Param("example") AnswerDOExample example);

    @UpdateProvider(type=AnswerDOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AnswerDO record);

    @Update({
        "update answer",
        "set student_id = #{studentId,jdbcType=INTEGER},",
          "problem_set_id = #{problemSetId,jdbcType=INTEGER},",
          "problem_id = #{problemId,jdbcType=INTEGER},",
          "student_ans = #{studentAns,jdbcType=TINYINT},",
          "istrue = #{istrue,jdbcType=TINYINT},",
          "right_ans = #{rightAns,jdbcType=TINYINT}",
        "where ans_id = #{ansId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AnswerDO record);
}