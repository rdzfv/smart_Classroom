package com.zjut.smartClassroom.Controller;

import com.alibaba.druid.util.StringUtils;
import com.zjut.smartClassroom.Service.PaperProblemService;
import com.zjut.smartClassroom.dataObject.PaperProblemView;
import com.zjut.smartClassroom.dataObject.ProblemPaper;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.model.UpdatePaperProblemModel;
import com.zjut.smartClassroom.repository.PaperRepository;
import com.zjut.smartClassroom.repository.ProblemPaperRepository;
import com.zjut.smartClassroom.repository.ProblemRepository;
import com.zjut.smartClassroom.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("/paperProblem")
@RequestMapping("/paperProblem")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")


public class PaperProblemController extends BaseController {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    @Autowired(required = false)
    private PaperProblemService paperProblemService;
    @Autowired(required = false)
    private PaperRepository paperRepository;
    @Autowired(required = false)
    private ProblemPaperRepository problemPaperRepository;
    @Autowired(required = false)
    private ProblemRepository problemRepository;

    // 根据老师选择的题目来插入试题
    @RequestMapping("/createNewPaper")
    @ResponseBody
    public CommonReturnType createNewPaper(@RequestParam("problemList")String problemList, @RequestParam("paperName")String paperName) throws BusinessException {
        // 入参校验
        if (StringUtils.isEmpty(problemList) || StringUtils.isEmpty(paperName)) throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        int flag = paperProblemService.createNewPaper(problemList, paperName);
        return CommonReturnType.create(flag);
    }

    // 根据paperId查询paper内的题目等详细信息
    @RequestMapping("/getPaperDetailByPaperId")
    @ResponseBody
    public CommonReturnType getPaperDetailByPaperId(@RequestParam("paper_id") int paperId) throws BusinessException {
        List<PaperProblemView> paperProblemList = paperProblemService.getDataByPaperId(paperId);
        return CommonReturnType.create(paperProblemList);
    }

    @RequestMapping("/deletePaperProblemByPaperId")
    @ResponseBody
    public CommonReturnType deletePaperProblemByPaperId(@RequestParam("paper_id") int paperId, @RequestParam("problem_id") int problemId) throws BusinessException {
        int flag = paperProblemService.deletePaperProblem(paperId, problemId);
        if (flag != 1){
            BusinessException businessException = new BusinessException(EnumBusinessError.PAPER_CHANGE_PROBLEM_FAILED);
            throw businessException;
        }
        List<PaperProblemView> paperProblemList = paperProblemService.getDataByPaperId(paperId);
        return CommonReturnType.create(paperProblemList);
    }

    @RequestMapping(value = "/updatePaperByPaperId", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType updatePaperByPaperId(UpdatePaperProblemModel updatePaperProblemModel) throws BusinessException {
        // 入参校验
        Integer paperId = updatePaperProblemModel.getPaperId();
        if (paperId == null) throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        ProblemPaper newPaperProblem = new ProblemPaper();
        newPaperProblem.setPaperId(paperId);
        // 如果传参旧问题id和新问题id，则进行替换业务
        if (updatePaperProblemModel.getNewProblemId() != null && updatePaperProblemModel.getProblemId() != null) {
            Integer newProblemId = updatePaperProblemModel.getNewProblemId();
            Integer problemId = updatePaperProblemModel.getProblemId();
            newPaperProblem.setProblemId(problemId);
            int flag = paperProblemService.updatePaperProblem(newPaperProblem, newProblemId);
            if (flag != 1) {
                BusinessException businessException = new BusinessException(EnumBusinessError.PAPER_CHANGE_PROBLEM_FAILED);
                throw businessException;
            }
        } else if (updatePaperProblemModel.getNewProblemId() == null) {
            // 如果未传参新问题id，则进行删除业务
            Integer problemId = updatePaperProblemModel.getProblemId();
            int flag = paperProblemService.deletePaperProblem(paperId, problemId);
            if (flag == 0) throw new BusinessException(EnumBusinessError.DELETE_FAILED);

        } else {
            // 如果未传参旧问题id，则进行插入业务
            Integer newProblemId = updatePaperProblemModel.getNewProblemId();
            ProblemPaper problemPaperInstance = new ProblemPaper();
            problemPaperInstance.setPaperId(paperId);
            problemPaperInstance.setProblemId(newProblemId);
            int flag = paperProblemService.insertProblemByPaperId(problemPaperInstance);
            if (flag == 0) throw new BusinessException(EnumBusinessError.ADD_FAILED);
        }

        List<PaperProblemView> paperProblemList = paperProblemService.getDataByPaperId(newPaperProblem.getPaperId());
        return CommonReturnType.create(paperProblemList);
    }
}
