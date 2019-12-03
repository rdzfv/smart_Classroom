package com.zjut.chocalate.Controller;

import com.alibaba.druid.util.StringUtils;
import com.zjut.chocalate.Service.ServiceTypeService;
import com.zjut.chocalate.Service.UserService;
import com.zjut.chocalate.dataObject.MemberInfo;
import com.zjut.chocalate.dataObject.ServiceTypeInfo;
import com.zjut.chocalate.dataObject.UserLoginInfo;
import com.zjut.chocalate.error.BusinessException;
import com.zjut.chocalate.error.EnumBusinessError;
import com.zjut.chocalate.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller("/serviceType")
@RequestMapping("/serviceType")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ServiceTypeController extends baseController {
    @Autowired
    private ServiceTypeService serviceTypeService;
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private ServiceTypeInfo serviceTypeInfoInstanse;
    @Autowired
    private ServiceTypeInfo serviceTypeInfoInstanse0;

    // 添加服务类型接口 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/addServiceType", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType addServiceType(@RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "detail", required = false) String detail,
            @RequestParam(value = "price", required = false) String priceStr
    ) throws BusinessException {
        // 入参校验
        if (priceStr == null) throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        double price = Double.parseDouble(priceStr);
        if(StringUtils.isEmpty(title) || StringUtils.isEmpty(detail)) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        serviceTypeInfoInstanse0.setTitle(title);
        serviceTypeInfoInstanse0.setDetail(detail);
        serviceTypeInfoInstanse0.setPrice(price);
        // 添加服务类型
        serviceTypeInfoInstanse = serviceTypeService.addServiceType(serviceTypeInfoInstanse0);
        return CommonReturnType.create(serviceTypeInfoInstanse);
    }

    // 修改服务类型接口 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/updateServiceType", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded;charset=UTF-8"})
    @ResponseBody
    public CommonReturnType updateServiceType(@RequestParam(value = "id", required = false) String idStr,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "detail", required = false) String detail,
            @RequestParam(value = "price", required = false) String priceStr
    ) throws BusinessException {
        // 入参校验
        if (priceStr == null || idStr == null) throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        double price = Double.parseDouble(priceStr);
        int id = Integer.parseInt(idStr);
        if(StringUtils.isEmpty(title) || StringUtils.isEmpty(detail)) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        serviceTypeInfoInstanse0.setTitle(title);
        serviceTypeInfoInstanse0.setDetail(detail);
        serviceTypeInfoInstanse0.setPrice(price);
        serviceTypeInfoInstanse0.setServiceid(id);
        // 修改服务类型
        serviceTypeInfoInstanse = serviceTypeService.updateServiceType(serviceTypeInfoInstanse0);
        return CommonReturnType.create(serviceTypeInfoInstanse);
    }

    // 查询服务类型接口 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/findServiceTypeById")
    @ResponseBody
    public CommonReturnType findServiceTypeById(@RequestParam(value = "id", required = false) String idStr) throws BusinessException {
        // 入参校验
        if (idStr == null) throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        int id = Integer.parseInt(idStr);
        // 查询服务类型
        serviceTypeInfoInstanse = serviceTypeService.findServiceTypeById(id);
        if (serviceTypeInfoInstanse == null) throw new BusinessException(EnumBusinessError.FIND_FAILED);
        return CommonReturnType.create(serviceTypeInfoInstanse);
    }

    // 删除服务类型接口 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/deleteServiceTypeById")
    @ResponseBody
    public CommonReturnType deleteServiceTypeById(@RequestParam(value = "id", required = false) String idStr) throws BusinessException {
        // 入参校验
        if (idStr == null) throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        int id = Integer.parseInt(idStr);
        // 查询服务类型
        serviceTypeInfoInstanse = serviceTypeService.deleteServiceTypeById(id);
        if (serviceTypeInfoInstanse == null) throw new BusinessException(EnumBusinessError.FIND_FAILED);
        return CommonReturnType.create(serviceTypeInfoInstanse);
    }
}
