package com.zjut.smartClassroom.Controller;

import com.zjut.smartClassroom.Service.PaperService;
import com.zjut.smartClassroom.dataObject.Paper;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("/paper")
@RequestMapping("/paper")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class PaperController extends BaseController {
    /**
     *@author John
     *@date 2019/12/5 21:45
     */

    @Autowired
    private PaperService paperService;


    @RequestMapping("/getAllPaperInfo")
    @ResponseBody
    public CommonReturnType getAllPaperInfo() throws BusinessException {
        List<Paper> paperList = paperService.getAllData();
        return CommonReturnType.create(paperList);
    }

    @RequestMapping(value = "/insertPaper", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType insertPaper(Paper newPaper) throws BusinessException {
        int flag = paperService.insertData(newPaper);
        if (flag != 1) {
            BusinessException businessException = new BusinessException(EnumBusinessError.PAPER_CREATE_FAILED);
            throw businessException;
        }
        return CommonReturnType.create(flag);
    }

    @RequestMapping("/deletePaperBypaperId")
    @ResponseBody
    public CommonReturnType deletePaperBypaperId(@RequestParam("paper_id") int paperId) throws BusinessException {
        int flag = paperService.deleteDataByPaperId(paperId);
        if (flag != 1) {
            BusinessException businessException = new BusinessException(EnumBusinessError.PAPER_DELETE_FAILED);
            throw businessException;
        }
        return CommonReturnType.create(flag);
    }

    @RequestMapping(value = "/updatePaperByPaperId", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType updatePaperByPaperId(Paper newPaper) throws BusinessException {
        int flag = paperService.updateDataByPaperId(newPaper);
        if (flag != 1) {
            BusinessException businessException = new BusinessException(EnumBusinessError.PAPER_UPDATE_FAILED);
            throw businessException;
        }
        return CommonReturnType.create(flag);
    }

    @RequestMapping("/getPaperByPaperId")
    @ResponseBody
    public CommonReturnType getPaperByPaperId(@RequestParam("paper_id") int paperId) throws BusinessException {
        Paper paper = paperService.getDataByPaperId(paperId);
        if (paper == null) {
            BusinessException businessException = new BusinessException(EnumBusinessError.PAPER_NOT_EXIST);
            throw businessException;
        }
        return CommonReturnType.create(paper);
    }
}
