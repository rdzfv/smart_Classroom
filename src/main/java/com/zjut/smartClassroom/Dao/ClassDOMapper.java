package com.zjut.smartClassroom.Dao;

import com.zjut.smartClassroom.dataObject.ClassDO;
import com.zjut.smartClassroom.dataObject.ClassDOExample;
import com.zjut.smartClassroom.dataObject.ClassDOKey;
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

public interface ClassDOMapper {
    @SelectProvider(type=ClassDOSqlProvider.class, method="countByExample")
    long countByExample(ClassDOExample example);

    @DeleteProvider(type=ClassDOSqlProvider.class, method="deleteByExample")
    int deleteByExample(ClassDOExample example);

    @Delete({
        "delete from class",
        "where teacher_id = #{teacherId,jdbcType=INTEGER}",
          "and course_id = #{courseId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(ClassDOKey key);

    @Insert({
        "insert into class (teacher_id, course_id, ",
        "class_classroom, class_name, ",
        "class_openyear)",
        "values (#{teacherId,jdbcType=INTEGER}, #{courseId,jdbcType=INTEGER}, ",
        "#{classClassroom,jdbcType=VARCHAR}, #{className,jdbcType=VARCHAR}, ",
        "#{classOpenyear,jdbcType=INTEGER})"
    })
    int insert(ClassDO record);

    @InsertProvider(type=ClassDOSqlProvider.class, method="insertSelective")
    int insertSelective(ClassDO record);

    @SelectProvider(type=ClassDOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="class_classroom", property="classClassroom", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_name", property="className", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_openyear", property="classOpenyear", jdbcType=JdbcType.INTEGER)
    })
    List<ClassDO> selectByExample(ClassDOExample example);

    @Select({
        "select",
        "teacher_id, course_id, class_classroom, class_name, class_openyear",
        "from class",
        "where teacher_id = #{teacherId,jdbcType=INTEGER}",
          "and course_id = #{courseId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="class_classroom", property="classClassroom", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_name", property="className", jdbcType=JdbcType.VARCHAR),
        @Result(column="class_openyear", property="classOpenyear", jdbcType=JdbcType.INTEGER)
    })
    ClassDO selectByPrimaryKey(ClassDOKey key);

    @UpdateProvider(type=ClassDOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ClassDO record, @Param("example") ClassDOExample example);

    @UpdateProvider(type=ClassDOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ClassDO record, @Param("example") ClassDOExample example);

    @UpdateProvider(type=ClassDOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ClassDO record);

    @Update({
        "update class",
        "set class_classroom = #{classClassroom,jdbcType=VARCHAR},",
          "class_name = #{className,jdbcType=VARCHAR},",
          "class_openyear = #{classOpenyear,jdbcType=INTEGER}",
        "where teacher_id = #{teacherId,jdbcType=INTEGER}",
          "and course_id = #{courseId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ClassDO record);
}