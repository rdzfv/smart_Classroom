package com.zjut.smartClassroom.Controller;

import com.alibaba.druid.util.StringUtils;
import com.zjut.smartClassroom.Service.HttpClient;
import com.zjut.smartClassroom.Service.UserService;
import com.zjut.smartClassroom.dataObject.Student;
import com.zjut.smartClassroom.dataObject.Teacher;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.response.CommonReturnType;
import com.zjut.smartClassroom.utils.Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author     ：xyy
 * @date       ：Created in 2019/12/02 12:45:23
 * @description：userController
 * @version:     1.0.0
 */
@Api("用户模块")
@Controller("/user")
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class UserController extends BaseController {
    // 引入
    @Autowired
    private UserService userService;
    // 引入
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private HttpClient httpClient;


//    /**
//     * @author     ：xyy
//     * @date       ：Created in 2019/12/02 12:45:23
//     * @description：用户登录接口（传入学生姓名[非空]、账户名[非空]、密码[非空]、openid[非空]、sessionkey[非空]）
//     * @version:     1.0.0
//     */
//    @ApiOperation("学生登录")
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @ResponseBody
//    public CommonReturnType login(@RequestBody() Student student) throws BusinessException {
//        System.out.println(student);
//        // 入参校验
//        if (StringUtils.isEmpty(student.getStudentName()) || StringUtils.isEmpty(student.getStudentAccount()) ||
//                StringUtils.isEmpty(student.getStudentPassword()) || StringUtils.isEmpty(student.getOpenId()) ||
//                StringUtils.isEmpty(student.getSessionKey())
//        ) {
//            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
//        }
//        // 用户登录服务
//        Student studentInstanse = userService.login(student);
//        if (studentInstanse == null) throw new BusinessException(EnumBusinessError.USER_NOT_VALIDATE);
//        return CommonReturnType.create(studentInstanse);
//    }


    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/18
     * @description： 通过学号获取学生信息
     * @version:     1.0.0
     */
    @ApiOperation("通过学号获取学生信息")
    @RequestMapping(value = "/getStudentInfoByStudentAccount", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType getStudentInfoByStudentAccount(int studentId) throws BusinessException {
        // 获取学生信息服务
        Student studentInstanse = userService.getStudentInfoByStudentAccount(studentId);
        if (studentInstanse == null) throw new BusinessException(EnumBusinessError.USER_NOT_VALIDATE);
        return CommonReturnType.create(studentInstanse);
    }


//    /**
//     * @author     ：xyy
//     * @date       ：Created in 2019/12/19
//     * @description： 通过教师账号获取教师信息
//     * @version:     1.0.0
//     */
//    @ApiOperation("通过教师账号获取学生信息")
//    @RequestMapping(value = "/getTeacherInfoByTeacherAccount", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonReturnType getTeacherInfoByTeacherAccount(int teacherId) throws BusinessException {
//        // 获取教师信息服务
//        Teacher teacherInstance = userService.getTeacherInfoByTeacherAccount(teacherId);
//        if (teacherInstance == null) throw new BusinessException(EnumBusinessError.USER_NOT_VALIDATE);
//        return CommonReturnType.create(teacherInstance);
//    }


    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/21 05:01
     * @description： 教师绑定
     * @version:     1.0.0
     */
    @ApiOperation("教师绑定")
    @RequestMapping(value = "/teacherBinding", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType teacherBinding(String teacherName, String teacherPassword, String teacherAccount, String code) throws BusinessException {
        System.out.println(teacherName);
        System.out.println(teacherPassword);
        System.out.println(teacherAccount);
        System.out.println(code);
        // 入参校验
        if (StringUtils.isEmpty(teacherName) ||
                StringUtils.isEmpty(code) || StringUtils.isEmpty(teacherAccount) ||
                StringUtils.isEmpty(teacherPassword)
        ) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        // 通过code获取openid
        // 发送http请求到微信平台
        // String url = "https://www.xuyuyan.cn/course/getPPTsByCourseId?courseId=1";
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wxc80f6fe4d1258003&&secret=77e61076f62a3bac86263af8d340905f&&js_code=" + code + "&grant_type=authorization_code";
        //post请求
        HttpMethod method = HttpMethod.GET;
        // 发送http请求并返回结果
        String wechatResult = httpClient.client_GET(url,method);
        System.out.println(wechatResult);
        // string结果转为json并获取openid
        Utils utils = new Utils();
        JSONObject wechatReturnJSON = utils.String2Json(wechatResult);
        if (wechatReturnJSON.get("openid") == null || wechatReturnJSON.get("session_key") == null) throw new BusinessException(EnumBusinessError.ILLEGAL_REQUEST);
        String openid = wechatReturnJSON.get("openid").toString();
        String session_key = wechatReturnJSON.get("session_key").toString();

        Teacher teacher = new Teacher();
        teacher.setTeacherAccount(teacherAccount);
        teacher.setTeacherPassword(teacherPassword);
        teacher.setTeacherName(teacherName);
        teacher.setOpenid(openid);

        // 用户登录服务
        Teacher teacherInstanse = userService.teacherBinding(teacher);
        if (teacherInstanse == null) throw new BusinessException(EnumBusinessError.USER_NOT_VALIDATE);
        return CommonReturnType.create(teacherInstanse);
    }


    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/21 02:10
     * @description： 学生修改密码
     * @version:     1.0.0
     */
    @ApiOperation("学生修改密码")
    @RequestMapping(value = "/updateStudentPassword", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType updateStudentPassword(int studentId, String passwoord) throws BusinessException {
        // 入参校验
        if (StringUtils.isEmpty(passwoord)) throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        // 修改密码
        Student studentInstanse = userService.updateStudentPassword(studentId, passwoord);
        if (studentInstanse == null) throw new BusinessException(EnumBusinessError.USER_NOT_VALIDATE);
        return CommonReturnType.create(studentInstanse);
    }


    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/21 04:59
     * @description： 教师登录
     * @version:     1.0.0
     */
    @ApiOperation("教师登录")
    @RequestMapping(value = "/teacherLogin", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType teacherLogin(String code) throws BusinessException {
        // 入参校验
        if (StringUtils.isEmpty(code)) throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        // 教师登录
        Teacher teacherResult = userService.teacherLogin(code);

        if (teacherResult == null) CommonReturnType.create(0);
        return CommonReturnType.create(teacherResult);
    }


    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/21 04:59
     * @description： 学生登录
     * @version:     1.0.0
     */
    @ApiOperation("学生登录")
    @RequestMapping(value = "/studentLogin", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType studentLogin(String code) throws BusinessException {
        // 入参校验
        if (StringUtils.isEmpty(code)) throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        // 教师登录
        Student studentResult = userService.studentLogin(code);

        if (studentResult == null) CommonReturnType.create(0);
        return CommonReturnType.create(studentResult);
    }



    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/21 05:13
     * @description： 学生绑定
     * @version:     1.0.0
     */
    @ApiOperation("学生绑定")
    @RequestMapping(value = "/studentBinding", method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType studentBinding(@RequestBody() Student student) throws BusinessException {

        // 入参校验
        if (StringUtils.isEmpty(student.getStudentName()) ||
                StringUtils.isEmpty(student.getSessionKey()) || StringUtils.isEmpty(student.getStudentAccount()) ||
                StringUtils.isEmpty(student.getStudentPassword())
        ) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        // 通过code获取openid
        // 发送http请求到微信平台
        String code = student.getSessionKey();
        // String url = "https://www.xuyuyan.cn/course/getPPTsByCourseId?courseId=1";
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wxc80f6fe4d1258003&&secret=77e61076f62a3bac86263af8d340905f&&js_code=" + code + "&grant_type=authorization_code";
        //post请求
        HttpMethod method = HttpMethod.GET;
        // 发送http请求并返回结果
        String wechatResult = httpClient.client_GET(url,method);
        System.out.println(wechatResult);
        // string结果转为json并获取openid
        Utils utils = new Utils();
        JSONObject wechatReturnJSON = utils.String2Json(wechatResult);
        if (wechatReturnJSON.get("openid") == null || wechatReturnJSON.get("session_key") == null) throw new BusinessException(EnumBusinessError.ILLEGAL_REQUEST);
        String openid = wechatReturnJSON.get("openid").toString();
        String session_key = wechatReturnJSON.get("session_key").toString();

        student.setOpenId(openid);

        // 用户登录服务
        Student studentInstanse = userService.studentBinding(student);
        if (studentInstanse == null) throw new BusinessException(EnumBusinessError.USER_NOT_VALIDATE);
        return CommonReturnType.create(studentInstanse);
    }



    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/21 02:10
     * @description： 教师修改密码
     * @version:     1.0.0
     */
    @ApiOperation("教师修改密码")
    @RequestMapping(value = "/updateTeacherPassword", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType updateTeacherPassword(int teacherId, String passwoord) throws BusinessException {
        // 入参校验
        if (StringUtils.isEmpty(passwoord)) throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        // 修改密码
        Teacher teacherInstanse = userService.updateTeacherPassword(teacherId, passwoord);
        if (teacherInstanse == null) throw new BusinessException(EnumBusinessError.USER_NOT_VALIDATE);
        return CommonReturnType.create(teacherInstanse);
    }
}
