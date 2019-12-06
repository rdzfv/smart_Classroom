package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,String> {

    // 这个涉及用户了，好像要openid，我有点实现不了。
    // 根据teacher_account查询老师
}
