package com.zjut.smartClassroom.Dao;

import com.zjut.smartClassroom.dataObject.StudentInformationDO;
import com.zjut.smartClassroom.dataObject.StudentInformationDOExample;
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

public interface StudentInformationDOMapper {
    @SelectProvider(type=StudentInformationDOSqlProvider.class, method="countByExample")
    long countByExample(StudentInformationDOExample example);

    @DeleteProvider(type=StudentInformationDOSqlProvider.class, method="deleteByExample")
    int deleteByExample(StudentInformationDOExample example);

    @Delete({
        "delete from student_information",
        "where student_id = #{studentId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer studentId);

    @Insert({
        "insert into student_information (student_id, person_characteristic)",
        "values (#{studentId,jdbcType=INTEGER}, #{personCharacteristic,jdbcType=VARCHAR})"
    })
    int insert(StudentInformationDO record);

    @InsertProvider(type=StudentInformationDOSqlProvider.class, method="insertSelective")
    int insertSelective(StudentInformationDO record);

    @SelectProvider(type=StudentInformationDOSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="person_characteristic", property="personCharacteristic", jdbcType=JdbcType.VARCHAR)
    })
    List<StudentInformationDO> selectByExample(StudentInformationDOExample example);

    @Select({
        "select",
        "student_id, person_characteristic",
        "from student_information",
        "where student_id = #{studentId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="person_characteristic", property="personCharacteristic", jdbcType=JdbcType.VARCHAR)
    })
    StudentInformationDO selectByPrimaryKey(Integer studentId);

    @UpdateProvider(type=StudentInformationDOSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StudentInformationDO record, @Param("example") StudentInformationDOExample example);

    @UpdateProvider(type=StudentInformationDOSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StudentInformationDO record, @Param("example") StudentInformationDOExample example);

    @UpdateProvider(type=StudentInformationDOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StudentInformationDO record);

    @Update({
        "update student_information",
        "set person_characteristic = #{personCharacteristic,jdbcType=VARCHAR}",
        "where student_id = #{studentId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(StudentInformationDO record);
}