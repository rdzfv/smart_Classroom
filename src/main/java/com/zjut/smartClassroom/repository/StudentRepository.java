package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // 根据学生id查找学生(测试)
    Student findByStudentid(Integer id);
    // 根据学生姓名，账号，密码，openId, sessionId查找学生账户
    Student findByOpenidAndAndSessionkeyAndStudentaccountAndStudentnameAndStudentpassword(String openId, String sessionKey, String account, String name, String password);
}
