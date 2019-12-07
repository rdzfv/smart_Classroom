package com.zjut.smartClassroom.Service;

import com.zjut.smartClassroom.error.BusinessException;
import org.springframework.stereotype.Service;
import com.zjut.smartClassroom.dataObject.Paper;

/**
 * @ProjectName: smartClassroom
 * @Package: com.zjut.smartClassroom.Service
 * @ClassName: PaperService
 * @Author: FrankWu
 * @Description: ${description}
 * @Date: 2019/12/7 13:10
 * @Version: 1.0
 */

@Service
public interface PaperService {
    // 通过练习卷ID查询练习卷实体
    Paper findPaperById(Integer paperId) throws BusinessException;
}
