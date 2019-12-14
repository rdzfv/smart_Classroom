package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.ProblemSet;
import com.zjut.smartClassroom.view.StudentCourseDetailView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @ProjectName: smartClassroom
 * @Package: com.zjut.smartClassroom.repository
 * @ClassName: StudentCourseDetailViewRepository
 * @Author: FrankWu
 * @Description: 对学生与课程视图进行数据操作
 * @Date: 2019/12/13 19:51
 * @Version: 1.0
 */
@Repository
public interface StudentCourseDetailViewRepository extends JpaRepository<StudentCourseDetailView, Integer> {
    List<StudentCourseDetailView> findStudentCourseDetailViewsByStudentId(Integer studentId);
}
