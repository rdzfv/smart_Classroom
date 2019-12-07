package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.dataObject.ProblemSet;
import com.zjut.smartClassroom.error.BusinessException;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: smartClassroom
 * @Package: com.zjut.smartClassroom.Service
 * @ClassName: ProblemSetService
 * @Author: FrankWu
 * @Description: ProblemSetService接口
 * @Date: 2019/12/7 11:19
 * @Version: 1.0
 */

@Service
public interface ProblemSetService {

    ProblemSet addProblemSet(ProblemSet problemSet) throws BusinessException;
}
