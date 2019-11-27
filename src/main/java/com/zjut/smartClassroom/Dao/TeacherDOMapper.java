package com.zjut.smartClassroom.Dao;

import com.zjut.smartClassroom.dataObject.TeacherDO;
import com.zjut.smartClassroom.dataObject.TeacherDOExample;
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

public interface TeacherDOMapper {
    @SelectProvider(type=TeacherDOSqlProvider.class, method="countByExample")
    long countByExample(TeacherDOExample example);

    @DeleteProvider(type=TeacherDOSqlProvider.class, method="deleteByExample")
    int deleteByExample(TeacherDOExample example);

    @Delete({
        "delete from teacher",
        "where teacher_id = #{teacherId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer teacherId);

    @Insert({
        "insert into teacher (teacher_id, teacher_name, ",
        "teacher_account, teacher_password, ",
        "teacher_sex, teacher_phone)",
        "values (#{teacherId,jdbcType=INTEGER}, #{teacherName,jdbcType=VARCHAR}, ",
        "#{teacherAccount,jdbcType=VARCHAR}, #{teacherPassword,jdbcType=VARCHAR}, ",
        "#{teacherSex,jdbcType=TINYINT}, #{teacherPhone,jdbcType=VARCHAR})"
    })
    int insert(TeacherDO record);

    @InsertProvider(type=TeacherDOSqlProvider.class, method="insertSelective")
    int insertSelective(TeacherDO record);

    @SelectProvider(type=TeacherDOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="teacher_name", property="teacherName", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher_account", property="teacherAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher_password", property="teacherPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher_sex", property="teacherSex", jdbcType=JdbcType.TINYINT),
        @Result(column="teacher_phone", property="teacherPhone", jdbcType=JdbcType.VARCHAR)
    })
    List<TeacherDO> selectByExample(TeacherDOExample example);

    @Select({
        "select",
        "teacher_id, teacher_name, teacher_account, teacher_password, teacher_sex, teacher_phone",
        "from teacher",
        "where teacher_id = #{teacherId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="teacher_name", property="teacherName", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher_account", property="teacherAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher_password", property="teacherPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher_sex", property="teacherSex", jdbcType=JdbcType.TINYINT),
        @Result(column="teacher_phone", property="teacherPhone", jdbcType=JdbcType.VARCHAR)
    })
    TeacherDO selectByPrimaryKey(Integer teacherId);

    @UpdateProvider(type=TeacherDOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TeacherDO record, @Param("example") TeacherDOExample example);

    @UpdateProvider(type=TeacherDOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TeacherDO record, @Param("example") TeacherDOExample example);

    @UpdateProvider(type=TeacherDOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TeacherDO record);

    @Update({
        "update teacher",
        "set teacher_name = #{teacherName,jdbcType=VARCHAR},",
          "teacher_account = #{teacherAccount,jdbcType=VARCHAR},",
          "teacher_password = #{teacherPassword,jdbcType=VARCHAR},",
          "teacher_sex = #{teacherSex,jdbcType=TINYINT},",
          "teacher_phone = #{teacherPhone,jdbcType=VARCHAR}",
        "where teacher_id = #{teacherId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TeacherDO record);
}