package com.zjut.smartClassroom.Dao;

import com.zjut.smartClassroom.dataObject.StudentClassCourseDO;
import com.zjut.smartClassroom.dataObject.StudentClassCourseDOExample;
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

public interface StudentClassCourseDOMapper {
    @SelectProvider(type=StudentClassCourseDOSqlProvider.class, method="countByExample")
    long countByExample(StudentClassCourseDOExample example);

    @DeleteProvider(type=StudentClassCourseDOSqlProvider.class, method="deleteByExample")
    int deleteByExample(StudentClassCourseDOExample example);

    @Delete({
        "delete from student_class_course",
        "where cour_stu_id = #{courStuId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer courStuId);

    @Insert({
        "insert into student_class_course (cour_stu_id, student_id, ",
        "teacher_id, course_id)",
        "values (#{courStuId,jdbcType=INTEGER}, #{studentId,jdbcType=INTEGER}, ",
        "#{teacherId,jdbcType=INTEGER}, #{courseId,jdbcType=INTEGER})"
    })
    int insert(StudentClassCourseDO record);

    @InsertProvider(type=StudentClassCourseDOSqlProvider.class, method="insertSelective")
    int insertSelective(StudentClassCourseDO record);

    @SelectProvider(type=StudentClassCourseDOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="cour_stu_id", property="courStuId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.INTEGER),
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER)
    })
    List<StudentClassCourseDO> selectByExample(StudentClassCourseDOExample example);

    @Select({
        "select",
        "cour_stu_id, student_id, teacher_id, course_id",
        "from student_class_course",
        "where cour_stu_id = #{courStuId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="cour_stu_id", property="courStuId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.INTEGER),
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER)
    })
    StudentClassCourseDO selectByPrimaryKey(Integer courStuId);

    @UpdateProvider(type=StudentClassCourseDOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StudentClassCourseDO record, @Param("example") StudentClassCourseDOExample example);

    @UpdateProvider(type=StudentClassCourseDOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StudentClassCourseDO record, @Param("example") StudentClassCourseDOExample example);

    @UpdateProvider(type=StudentClassCourseDOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StudentClassCourseDO record);

    @Update({
        "update student_class_course",
        "set student_id = #{studentId,jdbcType=INTEGER},",
          "teacher_id = #{teacherId,jdbcType=INTEGER},",
          "course_id = #{courseId,jdbcType=INTEGER}",
        "where cour_stu_id = #{courStuId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(StudentClassCourseDO record);
}