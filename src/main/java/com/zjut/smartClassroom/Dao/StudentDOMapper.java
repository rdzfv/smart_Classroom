package com.zjut.smartClassroom.Dao;

import com.zjut.smartClassroom.dataObject.StudentDO;
import com.zjut.smartClassroom.dataObject.StudentDOExample;
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

public interface StudentDOMapper {
    @SelectProvider(type=StudentDOSqlProvider.class, method="countByExample")
    long countByExample(StudentDOExample example);

    @DeleteProvider(type=StudentDOSqlProvider.class, method="deleteByExample")
    int deleteByExample(StudentDOExample example);

    @Delete({
        "delete from student",
        "where student_id = #{studentId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer studentId);

    @Insert({
        "insert into student (student_id, student_name, ",
        "student_password, student_sex, ",
        "student_account, openid, ",
        "session_key)",
        "values (#{studentId,jdbcType=INTEGER}, #{studentName,jdbcType=VARCHAR}, ",
        "#{studentPassword,jdbcType=VARCHAR}, #{studentSex,jdbcType=TINYINT}, ",
        "#{studentAccount,jdbcType=VARCHAR}, #{openid,jdbcType=VARCHAR}, ",
        "#{sessionKey,jdbcType=VARCHAR})"
    })
    int insert(StudentDO record);

    @InsertProvider(type=StudentDOSqlProvider.class, method="insertSelective")
    int insertSelective(StudentDO record);

    @SelectProvider(type=StudentDOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="student_name", property="studentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_password", property="studentPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_sex", property="studentSex", jdbcType=JdbcType.TINYINT),
        @Result(column="student_account", property="studentAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
        @Result(column="session_key", property="sessionKey", jdbcType=JdbcType.VARCHAR)
    })
    List<StudentDO> selectByStudentDO(StudentDO example);

    @Select({
        "select",
        "student_id, student_name, student_password, student_sex, student_account, openid, ",
        "session_key",
        "from student",
        "where student_id = #{studentId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="student_name", property="studentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_password", property="studentPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_sex", property="studentSex", jdbcType=JdbcType.TINYINT),
        @Result(column="student_account", property="studentAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
        @Result(column="session_key", property="sessionKey", jdbcType=JdbcType.VARCHAR)
    })
    StudentDO selectByPrimaryKey(Integer studentId);

    @UpdateProvider(type=StudentDOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StudentDO record, @Param("example") StudentDOExample example);

    @UpdateProvider(type=StudentDOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StudentDO record, @Param("example") StudentDOExample example);

    @UpdateProvider(type=StudentDOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StudentDO record);

    @Update({
        "update student",
        "set student_name = #{studentName,jdbcType=VARCHAR},",
          "student_password = #{studentPassword,jdbcType=VARCHAR},",
          "student_sex = #{studentSex,jdbcType=TINYINT},",
          "student_account = #{studentAccount,jdbcType=VARCHAR},",
          "openid = #{openid,jdbcType=VARCHAR},",
          "session_key = #{sessionKey,jdbcType=VARCHAR}",
        "where student_id = #{studentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(StudentDO record);
}