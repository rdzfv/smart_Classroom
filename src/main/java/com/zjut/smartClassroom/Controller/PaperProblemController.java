package com.zjut.smartClassroom.Controller;

import com.zjut.smartClassroom.Service.PaperProblemService;
import com.zjut.smartClassroom.dataObject.PaperProblemView;
import com.zjut.smartClassroom.dataObject.ProblemPaper;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller("/paperProblem")
@RequestMapping("/paperProblem")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")


public class PaperProblemController {

    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    @Autowired(required = false)
    private PaperProblemService paperProblemService;
    @Autowired(required = false)
    private PaperProblemView paperProblemView;
    @Autowired(required = false)
    private List<PaperProblemView> paperProblemList;

    // 根据老师选择的题目来插入试题
    @RequestMapping("/createNewPaper")
    @ResponseBody
    public CommonReturnType createNewPaper(@RequestParam("problemList")String problemList,@RequestParam("paper_id")int paperId) throws BusinessException {
        String[] intArr = problemList.split(",");
        System.out.println(intArr);
        // 注：这边好像无法用spring进行新的创建，只能手工创建新的对象,下面的paperProblemList也是一个道理
        ProblemPaper paperProblem;
        for (String i : intArr) {
            paperProblem = new ProblemPaper();
            int temp = Integer.parseInt(i);
            paperProblem.setPaperId(paperId);
            paperProblem.setProblemId(temp);
            paperProblemService.insertProblemByPaperId(paperProblem);
        }
        paperProblemList = paperProblemService.getDataByPaperId(paperId);
        if (paperProblemList.size() == 0){
            BusinessException businessException = new BusinessException(EnumBusinessError.PAPER_PROBLEM_CREATE_FAILED);
            throw businessException;
        }
        System.out.println(paperProblemList);
        return CommonReturnType.create(paperProblemList);
    }

    // 根据paperId查询paper内的题目等详细信息
    @RequestMapping("/getPaperDetailByPaperId")
    @ResponseBody
    public CommonReturnType getPaperDetailByPaperId(@RequestParam("paper_id")int paperId) throws BusinessException{
        paperProblemList = paperProblemService.getDataByPaperId(paperId);
        if (paperProblemList == null){
            BusinessException businessException = new BusinessException(EnumBusinessError.PAPER_NOT_HAVE_PROBLEM);
            throw businessException;
        }
        return CommonReturnType.create(paperProblemList);
    }

    @RequestMapping(value = "/updatePaperByPaperId",method = RequestMethod.POST,consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    // 这里仅仅做试验，看看post情况下能不能更新，如果觉得格式写的太low的话那就干脆改成get好了
    public CommonReturnType updatePaperByPaperId(@RequestParam("paper_id")int paperId,@RequestParam("problem_id")int problemId,@RequestParam("problem_id_new")int newProblemId) throws BusinessException{
        ProblemPaper newPaperProblem = new ProblemPaper();
        newPaperProblem.setPaperId(paperId);
        newPaperProblem.setProblemId(problemId);
        int flag = paperProblemService.updatePaperProblem(newPaperProblem, newProblemId);
        if (flag != 1){
            BusinessException businessException = new BusinessException(EnumBusinessError.PAPER_CHANGE_PROBLEM_FAILED);
            throw businessException;
        }
        paperProblemList = paperProblemService.getDataByPaperId(newPaperProblem.getPaperId());
        return CommonReturnType.create(paperProblemList);
    }

    @RequestMapping("/deletePaperProblemByPaperId")
    @ResponseBody
    public CommonReturnType deletePaperProblemByPaperId(@RequestParam("paper_id")int paperId,@RequestParam("problem_id")int problemId) throws BusinessException{
        int flag = paperProblemService.deletePaperProblem(paperId,problemId);
        if (flag != 1){
            BusinessException businessException = new BusinessException(EnumBusinessError.PAPER_CHANGE_PROBLEM_FAILED);
            throw businessException;
        }
        paperProblemList = paperProblemService.getDataByPaperId(paperId);
        return CommonReturnType.create(paperProblemList);
    }
}
