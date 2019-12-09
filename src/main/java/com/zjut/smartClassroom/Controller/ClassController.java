package com.zjut.smartClassroom.Controller;

import com.alibaba.druid.util.StringUtils;
import com.zjut.smartClassroom.Service.ClassService;
import com.zjut.smartClassroom.dataObject.AnswerSituation;
import com.zjut.smartClassroom.dataObject.Class;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * @author ：dzy
 * @date ：Created in 2019/12/05 20:28:23
 * @description： ClassController
 * @version: 1.0.0
 */
@Controller("/class")
@RequestMapping("/class")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ClassController extends BaseController {
    @Autowired
    ClassService classService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * @author ：dzy
     * @date ：Created in 2019/12/05 20:30:23
     * @description： 获取所有教学班信息
     * @version: 1.0.0
     */
    @RequestMapping(value = "/getAllClass")
    @ResponseBody
    public CommonReturnType getAllClass() throws BusinessException {
        // 通过problemSetId查询题目详情
        ArrayList<Class> classList = classService.getAllClass();
        return CommonReturnType.create(classList);
    }

    /**
     * @author ：dzy
     * @date ：Created in 2019/12/06 9:30:23
     * @description： 获取所有教学班信息
     * @version: 1.0.0
     */
    @RequestMapping(value = "/addClass")
    @ResponseBody
    public CommonReturnType addClass(Class class_) throws BusinessException {
        // 入参校验
        if ( (class_.getClassOpenyear() == null) || class_.getCourseId() == null ||
                class_.getTeacherId() == null || StringUtils.isEmpty(class_.getClassClassroom()) ||
                class_.getClassOpenyear() == null || StringUtils.isEmpty(class_.getClassName())
        ) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        // 查询所有教学班
        Class classResult = classService.addClass(class_);
        return CommonReturnType.create(classResult);
    }

    /**
     * @author ：dzy
     * @date ：Created in 2019/12/06 13:46:23
     * @description： 更新教学班信息
     * @version: 1.0.0
     */
    @RequestMapping(value = "/updateClass")
    @ResponseBody
    public CommonReturnType updateClass(Class class_) throws BusinessException {
        if (StringUtils.isEmpty(class_.getTeacherId() + "") || StringUtils.isEmpty(class_.getCourseId() + "")) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        //更新教学班
        Class classResult = classService.updateClass(class_);
        return CommonReturnType.create(classResult);
    }
}
