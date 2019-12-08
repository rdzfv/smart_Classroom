package com.zjut.smartClassroom.Controller;
import com.alibaba.druid.util.StringUtils;
import com.zjut.smartClassroom.Service.ClassService;
import com.zjut.smartClassroom.dataObject.ClassInformation;
import com.zjut.smartClassroom.dataObject.Class;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * @author: Hefz.
 * @date: 2019/12/6.
 * @description:
 */
@Controller("/class")
@RequestMapping("/class")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ClassController extends baseController{
    @Autowired
    private ClassService classService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * @author     ：Hefz
     * @date       ：Created in 2019/12/03 12:45:23
     * @description：use classId to get class information
     * @version:     1.0.0
     */
    @RequestMapping(value = "/getPPTSetByClassId")
    @ResponseBody
    public CommonReturnType getPPTSetByClassId(int classId) throws BusinessException {
        // 通过problemId查询题目详情
        ClassInformation classInformation = classService.getPPTSetByClassId(classId);
        return CommonReturnType.create(classInformation);
    }
}
