package com.zjut.smartClassroom.Controller;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.document.sentence.Sentence;
import com.hankcs.hanlp.model.crf.CRFLexicalAnalyzer;
import com.hankcs.hanlp.seg.common.Term;
import com.zjut.smartClassroom.Service.CourseService;
import com.zjut.smartClassroom.Service.PaperService;
import com.zjut.smartClassroom.dataObject.Paper;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.response.CommonReturnType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Api("hanlp接口")
@Controller("/hanlp")
@RequestMapping("/hanlp")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class HanlpController extends BaseController {
    /**
     * @author John
     * @date 2019/12/5 21:45
     */


    @ApiOperation("分词")
    @RequestMapping(value = "/hanlpStr", method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType hanlpStr(String str) throws BusinessException, IOException {
        List<Term> hanlpList = HanLP.segment(str);
        ArrayList<String> strList = new ArrayList<>();
        for (int i = 0; i< hanlpList.size(); i ++) {
            strList.add(hanlpList.get(i).word);
        }
        System.out.println(strList);
        return CommonReturnType.create(strList);
    }
}
