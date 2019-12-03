package com.zjut.chocalate.Controller;

import com.alibaba.druid.util.StringUtils;
import com.zjut.chocalate.Service.ServService;
import com.zjut.chocalate.Service.ServiceTypeService;
import com.zjut.chocalate.dataObject.ServiceRecordInfo;
import com.zjut.chocalate.dataObject.ServiceTypeInfo;
import com.zjut.chocalate.error.BusinessException;
import com.zjut.chocalate.error.EnumBusinessError;
import com.zjut.chocalate.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Date;
import java.util.List;

@Controller("/serviceRecord")
@RequestMapping("/serviceRecord")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ServController extends baseController {
    @Autowired
    private ServService servService;
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private ServiceRecordInfo serviceRecordInfoInstance;
    @Autowired
    private ServiceRecordInfo serviceRecordInfoInstanse0;

    // 添加服务记录接口
    @RequestMapping(value = "/addServiceRecord", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType addServiceType(@RequestParam(value = "datetime", required = false) String datetimeStr,
                                           @RequestParam(value = "typeId", required = false) String typeIdStr,
                                           @RequestParam(value = "comments", required = false) String comments,
                                           @RequestParam(value = "staffId", required = false) String staffIdStr
    ) throws BusinessException {
        // 入参校验
        if (datetimeStr == null || typeIdStr == null || staffIdStr == null) throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        DateFormat format2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = null;
        // String转Date
        try {
            datetime = format2.parse(datetimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        //Date转String
//        date=new Date();
//        str=format1.format(date);
//        str=format2.format(date);
        int typeId = Integer.parseInt(typeIdStr);
        int staffId = Integer.parseInt(staffIdStr);
        if(StringUtils.isEmpty(comments)) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        serviceRecordInfoInstanse0.setDatetime(datetime);
        serviceRecordInfoInstanse0.setComments(comments);
        serviceRecordInfoInstanse0.setTypeid(typeId);
        serviceRecordInfoInstanse0.setStaffid(staffId);
        // 添加服务记录
        serviceRecordInfoInstance = servService.addServiceRecord(serviceRecordInfoInstanse0);
        return CommonReturnType.create(serviceRecordInfoInstance);
    }

    // 修改服务记录接口
    @RequestMapping(value = "/updateServiceRecord", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType updateServiceType(@RequestParam(value = "id") String idStr,
                                              @RequestParam(value = "datetime", required = false) String datetimeStr,
                                              @RequestParam(value = "typeId", required = false) String typeIdStr,
                                              @RequestParam(value = "comments", required = false) String comments,
                                              @RequestParam(value = "staffId", required = false) String staffIdStr
    ) throws BusinessException {
        // 入参校验
        if (datetimeStr == null || idStr == null || typeIdStr == null || staffIdStr == null) throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        DateFormat format2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = null;
        // String转Date
        try {
            datetime = format2.parse(datetimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 参数转换
        int typeId = Integer.parseInt(typeIdStr);
        int staffId = Integer.parseInt(staffIdStr);
        int id = Integer.parseInt(idStr);
        if(StringUtils.isEmpty(comments)) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        serviceRecordInfoInstanse0.setServicerecordid(id);
        serviceRecordInfoInstanse0.setDatetime(datetime);
        serviceRecordInfoInstanse0.setComments(comments);
        serviceRecordInfoInstanse0.setTypeid(typeId);
        serviceRecordInfoInstanse0.setStaffid(staffId);
        System.out.println("controller:" + serviceRecordInfoInstanse0.getServicerecordid());
        // 修改服务记录
        serviceRecordInfoInstance = servService.updateServiceRecord(serviceRecordInfoInstanse0);
        return CommonReturnType.create(serviceRecordInfoInstance);
    }

    // 查询服务记录接口(单次)（通过id）
    @RequestMapping(value = "/findServiceRecordById")
    @ResponseBody
    public CommonReturnType findServiceRecordById(@RequestParam(value = "id") int id) throws BusinessException {
        // 查询服务记录
        serviceRecordInfoInstance = servService.findServiceRecordById(id);
        if (serviceRecordInfoInstance == null) throw new BusinessException(EnumBusinessError.FIND_FAILED);
        return CommonReturnType.create(serviceRecordInfoInstance);
    }

    // 删除服务记录接口
    @RequestMapping(value = "/deleteServiceRecordById")
    @ResponseBody
    public CommonReturnType deleteServiceRecordById(@RequestParam(value = "id") int id) throws BusinessException {
        // 删除服务记录
        servService.deleteServiceRecordById(id);
        return CommonReturnType.create(serviceRecordInfoInstance);
    }

    // 查询用户一周服务记录（通过会员id）
    @RequestMapping(value = "/findWeeklyServiceRecordsByMemberId")
    @ResponseBody
    public CommonReturnType findWeeklyServiceRecordsByMemberId(@RequestParam(value = "id") int id) throws BusinessException {
        // 查询一周服务记录
        List<ServiceRecordInfo> serviceRecordInfos = servService.findWeeklyServiceRecordsByMemberId(id);
        return CommonReturnType.create(serviceRecordInfos);
    }
}
