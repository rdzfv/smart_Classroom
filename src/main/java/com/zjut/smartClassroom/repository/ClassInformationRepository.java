package com.zjut.smartClassroom.repository;

/**
 * @author: Hefz.
 * @date: 2019/12/6.
 * @description:
 */

import com.zjut.smartClassroom.dataObject.ClassInformation;
import com.zjut.smartClassroom.dataObject.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassInformationRepository extends JpaRepository<ClassInformation, Integer>{
    //use class_id to find class information
    ClassInformation findByClassId(int classId);
}
