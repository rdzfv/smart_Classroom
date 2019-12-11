package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.Student;
import com.zjut.smartClassroom.dataObject.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findByTeacherId(int teacherId);

    // 根据学生姓名，账号，密码，openId, sessionId查找学生账户
    Teacher findByOpenIdAndSessionKeyAndTeacherAccountAndTeacherNameAndTeacherPassword(String openId, String sessionKey, String account, String name, String password);
}
