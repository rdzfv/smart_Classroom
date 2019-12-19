package com.zjut.smartClassroom.Controller;

import com.alibaba.druid.util.StringUtils;
import com.zjut.smartClassroom.Service.ClassService;
import com.zjut.smartClassroom.dataObject.Class;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author ：dzy
 * @date ：Created in 2019/12/05 20:28:23
 * @description： ClassController
 * @version: 1.0.0
 */
@Controller("/class")
@RequestMapping("/class")
@Api("教学班接口")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ClassController extends BaseController {
    @Autowired
    ClassService classService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * @author ：dzy
     * @date ：Created in 2019/12/05 20:30:23
     * @description： 获取教师教授的全部班级
     * @version: 1.0.0
     */
    @ApiOperation("获取教师教授的全部班级")
    @RequestMapping(value = "/getClassesByTeahcerid", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType getAllClassByTeacherId(int teacherId) throws BusinessException {
        // 通过problemSetId查询题目详情
        ArrayList<Class> classList = classService.getAllClassByTeacherId(teacherId);
        return CommonReturnType.create(classList);
    }

    /**
     * @author ：dzy
     * @date ：Created in 2019/12/06 9:30:23
     * @description： 添加班级
     * @version: 1.0.0
     */
    @ApiOperation("添加教学班级")
    @RequestMapping(value = "/addClass", method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType addClass(@RequestBody() Class class_) throws BusinessException {
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
    @ApiOperation("更新教学班级信息")
    @RequestMapping(value = "/updateClass", method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType updateClass(@RequestBody() Class class_) throws BusinessException {
        if (StringUtils.isEmpty(class_.getTeacherId() + "") || StringUtils.isEmpty(class_.getCourseId() + "")) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        //更新教学班
        Class classResult = classService.updateClass(class_);
        return CommonReturnType.create(classResult);
    }


    /**
     * @author ：xyy
     * @date ：Created in 2019/12/05 22:15
     * @description： 获取全部班级
     * @version: 1.0.0
     */
    @ApiOperation("获取全部班级")
    @RequestMapping(value = "/getAllClasses", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType getAllClass() throws BusinessException {
        // 通过problemSetId查询题目详情
        List<Class> classList = classService.getAllClass();
        return CommonReturnType.create(classList);
    }
}
