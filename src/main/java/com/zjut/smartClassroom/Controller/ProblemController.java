package com.zjut.smartClassroom.Controller;

import com.zjut.smartClassroom.Service.ProblemService;
import com.zjut.smartClassroom.dataObject.Problem;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("/problem")
@RequestMapping("/problem")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ProblemController {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    @Autowired(required = false)
    private List<Problem> problemList;
    @Autowired
    private ProblemService problemService;

    @RequestMapping("/getAllProblem")
    @ResponseBody
    public CommonReturnType getAllProblem() throws BusinessException {
        problemList = problemService.getAllData();
        if (problemList == null){
            BusinessException businessException = new BusinessException(EnumBusinessError.PROBLEM_NOT_EXIST);
            throw businessException;
        }
        return CommonReturnType.create(problemList);
    }

    /**
     * John结束部分
     */
}
