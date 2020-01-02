package com.zjut.smartClassroom.Controller;

import com.zjut.smartClassroom.Service.CourseService;
import com.zjut.smartClassroom.Service.PaperService;
import com.zjut.smartClassroom.dataObject.Paper;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.response.CommonReturnType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api("paper接口")
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
    @Autowired
    private CourseService courseService;

    @ApiOperation("获取全部paper信息")
    @RequestMapping(value = "/getAllPaperInfo", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType getAllPaperInfo() throws BusinessException {
        List<Paper> paperList = paperService.getAllData();
        return CommonReturnType.create(paperList);
    }

    @ApiOperation("创建paper")
    @RequestMapping(value = "/insertPaper", method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType insertPaper(@RequestBody() Paper newPaper) throws BusinessException {
        Paper flag = paperService.insertData(newPaper);
        if (flag == null) {
            BusinessException businessException = new BusinessException(EnumBusinessError.PAPER_CREATE_FAILED);
            throw businessException;
        }
        return CommonReturnType.create(flag);
    }

    @ApiOperation("通过paperId删除paper")
    @RequestMapping(value = "/deletePaperBypaperId", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType deletePaperBypaperId(@RequestParam("paper_id") int paperId) throws BusinessException {
        int flag = paperService.deleteDataByPaperId(paperId);
        if (flag != 1) {
            BusinessException businessException = new BusinessException(EnumBusinessError.PAPER_DELETE_FAILED);
            throw businessException;
        }
        return CommonReturnType.create(flag);
    }

    @ApiOperation("通过paperId更新paper")
    @RequestMapping(value = "/updatePaperByPaperId", method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType updatePaperByPaperId(@RequestBody() Paper newPaper) throws BusinessException {
        Paper flag = paperService.updateDataByPaperId(newPaper);
        if (flag == null) {
            BusinessException businessException = new BusinessException(EnumBusinessError.PAPER_UPDATE_FAILED);
            throw businessException;
        }
        return CommonReturnType.create(flag);
    }

    @ApiOperation("通过paperId获取paper")
    @RequestMapping(value = "/getPaperByPaperId", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType getPaperByPaperId(@RequestParam("paper_id") int paperId) throws BusinessException {
        Paper paper = paperService.getDataByPaperId(paperId);
        if (paper == null) {
            BusinessException businessException = new BusinessException(EnumBusinessError.PAPER_NOT_EXIST);
            throw businessException;
        }
        return CommonReturnType.create(paper);
    }

    /**
     *@author xyy
     *@date 2019/12/12 22:07
     */
    @ApiOperation("通过problemSetId获取paperList")
    @RequestMapping(value = "/getPaperListByProblemSetId", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType getPaperListByProblemSetId(int problemSetId) throws BusinessException {
        ArrayList<Paper> paperIds = paperService.getPaperListByProblemSetId(problemSetId);
        return CommonReturnType.create(paperIds);
    }


    /**
     *@author xyy
     *@date 2020/01/01 23:40
     */
    @ApiOperation("通过courseId获取paperList")
    @RequestMapping(value = "/getPaperListByCourseId", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType getPaperListByCourseId(int courseId) throws BusinessException {
        ArrayList<Paper> paperIds = paperService.getPaperListByCourseId(courseId);
        return CommonReturnType.create(paperIds);
    }
}
