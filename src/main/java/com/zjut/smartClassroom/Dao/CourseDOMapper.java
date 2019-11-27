package com.zjut.smartClassroom.Dao;

import com.zjut.smartClassroom.dataObject.CourseDO;
import com.zjut.smartClassroom.dataObject.CourseDOExample;
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

public interface CourseDOMapper {
    @SelectProvider(type=CourseDOSqlProvider.class, method="countByExample")
    long countByExample(CourseDOExample example);

    @DeleteProvider(type=CourseDOSqlProvider.class, method="deleteByExample")
    int deleteByExample(CourseDOExample example);

    @Delete({
        "delete from course",
        "where course_id = #{courseId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer courseId);

    @Insert({
        "insert into course (course_id, course_name, ",
        "course_credit, course_method, ",
        "course_picUrl, course_ppt_url)",
        "values (#{courseId,jdbcType=INTEGER}, #{courseName,jdbcType=VARCHAR}, ",
        "#{courseCredit,jdbcType=INTEGER}, #{courseMethod,jdbcType=VARCHAR}, ",
        "#{coursePicurl,jdbcType=VARCHAR}, #{coursePptUrl,jdbcType=VARCHAR})"
    })
    int insert(CourseDO record);

    @InsertProvider(type=CourseDOSqlProvider.class, method="insertSelective")
    int insertSelective(CourseDO record);

    @SelectProvider(type=CourseDOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="course_name", property="courseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_credit", property="courseCredit", jdbcType=JdbcType.INTEGER),
        @Result(column="course_method", property="courseMethod", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_picUrl", property="coursePicurl", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_ppt_url", property="coursePptUrl", jdbcType=JdbcType.VARCHAR)
    })
    List<CourseDO> selectByExample(CourseDOExample example);

    @Select({
        "select",
        "course_id, course_name, course_credit, course_method, course_picUrl, course_ppt_url",
        "from course",
        "where course_id = #{courseId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="course_name", property="courseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_credit", property="courseCredit", jdbcType=JdbcType.INTEGER),
        @Result(column="course_method", property="courseMethod", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_picUrl", property="coursePicurl", jdbcType=JdbcType.VARCHAR),
        @Result(column="course_ppt_url", property="coursePptUrl", jdbcType=JdbcType.VARCHAR)
    })
    CourseDO selectByPrimaryKey(Integer courseId);

    @UpdateProvider(type=CourseDOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CourseDO record, @Param("example") CourseDOExample example);

    @UpdateProvider(type=CourseDOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CourseDO record, @Param("example") CourseDOExample example);

    @UpdateProvider(type=CourseDOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CourseDO record);

    @Update({
        "update course",
        "set course_name = #{courseName,jdbcType=VARCHAR},",
          "course_credit = #{courseCredit,jdbcType=INTEGER},",
          "course_method = #{courseMethod,jdbcType=VARCHAR},",
          "course_picUrl = #{coursePicurl,jdbcType=VARCHAR},",
          "course_ppt_url = #{coursePptUrl,jdbcType=VARCHAR}",
        "where course_id = #{courseId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CourseDO record);
}