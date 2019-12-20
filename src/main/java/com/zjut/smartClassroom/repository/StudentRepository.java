package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author     ：xyy
 * @date       ：Created in 2019/12/02 12:45:23
 * @description：StudentRepository
 * @version:     1.0.0
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // 根据学生id查找学生(测试)
    Student findByStudentId(Integer id);
    // 根据学号查找学生
    Student findByStudentAccount(String studentAccount);
    // 根据学生姓名，账号，密码，openId, sessionId查找学生账户
    Student findByOpenIdAndSessionKeyAndStudentAccountAndStudentNameAndStudentPassword(String openId, String sessionKey, String account, String name, String password);
    Student findByOpenId(String openid);
    Student findByStudentAccountAndAndStudentNameAndStudentPassword(String account, String name, String password);
}

