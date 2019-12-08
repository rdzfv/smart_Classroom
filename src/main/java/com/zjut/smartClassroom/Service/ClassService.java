package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.ClassInformation;
import com.zjut.smartClassroom.dataObject.Class;
import com.zjut.smartClassroom.error.BusinessException;
import org.springframework.stereotype.Service;
/**
 * @author: Hefz.
 * @date: 2019/12/6.
 * @description:
 */
@Service
public interface ClassService {
    //use classId to get class information
    ClassInformation getPPTSetByClassId(int classId) throws BusinessException;
}
