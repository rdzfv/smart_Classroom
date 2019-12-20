package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.Student;
import com.zjut.smartClassroom.dataObject.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findByTeacherId(int teacherId);
    Teacher findByOpenidAndSessionKeyAndTeacherAccountAndTeacherNameAndTeacherPassword(String openId, String sessioonkey, String teacherAccount, String teacherName, String teacherPassword);
    Teacher findByTeacherAccountAndTeacherNameAndTeacherPassword(String account, String name, String password);
    Teacher findByOpenid(String openid);
}
