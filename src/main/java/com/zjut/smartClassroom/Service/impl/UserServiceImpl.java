package com.zjut.smartClassroom.Service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.zjut.smartClassroom.error.BusinessException;
import com.zjut.smartClassroom.error.EnumBusinessError;
import com.zjut.smartClassroom.repository.StudentRepository;
import com.zjut.smartClassroom.Service.*;
import com.zjut.smartClassroom.dataObject.*;
import com.zjut.smartClassroom.repository.TeacherRepository;
import com.zjut.smartClassroom.utils.Utils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author     ：xyy
 * @date       ：Created in 2019/12/02 12:45:23
 * @description：UserService接口的实现类
 * @version:     1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)//引入
    private StudentRepository studentRepository;
    @Autowired(required = false)//引入
    private TeacherRepository teacherRepository;
    @Autowired(required = false)
    private HttpClient httpClient;


    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/02 12:45:23
     * @description：通过用户id获取用户信息
     * @version:     1.0.0
     */
    @Override
    @Transactional
    public Student getUserById(int id) {
        Student student = studentRepository.findByStudentId(id);
        return student;

    }

    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/02 12:45:23
     * @description：用户登录(传入student对象)
     * @version:     1.0.0
     */
    @Override
    @Transactional
    public Student login(Student student) throws BusinessException {
        Student studentResult = studentRepository.findByOpenIdAndSessionKeyAndStudentAccountAndStudentNameAndStudentPassword(
                student.getOpenId(), student.getSessionKey(), student.getStudentAccount(), student.getStudentName(), student.getStudentPassword()
        );
        return studentResult;
    }

    /**
     * @Method findTeacherById
     * @Author FrankWu
     * @Version  1.0
     * @Description
     * @Return com.zjut.smartClassroom.dataObject.Teacher
     * @Exception
     * @Date 2019/12/7
     * @Time 16:34
     */
    @Override
    @Transactional
    public Teacher findTeacherById(int teacherId) throws BusinessException {
        Teacher teacherResult = teacherRepository.findByTeacherId(teacherId);
        if (teacherResult == null) {
            throw new BusinessException(EnumBusinessError.TEACHER_NOT_EXIST);
        }
        return teacherResult;
    }


    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/18
     * @description: 通过学号获取学生信息
     * @version:     1.0.0
     */
    @Override
    @Transactional
    public Student getStudentInfoByStudentAccount(int studentId) throws BusinessException{
        Student studentResult = studentRepository.findByStudentId(studentId);
        if (studentResult == null){
            throw new BusinessException(EnumBusinessError.STUDENT_NOT_EXIST);
        }
        return studentResult;
    }


    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/19 21:24
     * @description：用户登录(传入Teacher对象)
     * @version:     1.0.0
     */
    @Override
    public Teacher teacherBinding(Teacher teacher) throws BusinessException {

        Teacher teacherResult = teacherRepository.findByTeacherAccountAndTeacherNameAndTeacherPassword(
                teacher.getTeacherAccount(), teacher.getTeacherName(), teacher.getTeacherPassword()
        );
        if (teacherResult == null) throw new BusinessException(EnumBusinessError.TEACHER_NOT_EXIST);
        // 把openId写入数据库
        Teacher teacherResultAfterAddingOpenid = teacherRepository.save(teacher);
        return teacherResultAfterAddingOpenid;
    }



    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/21 01:13
     * @description： 学生修改密码
     * @version:     1.0.0
     */

    @Override
    public Student updateStudentPassword(int studentId, String password) throws BusinessException {
        Student student = new Student();
        student.setStudentId(studentId);
        student.setStudentPassword(password);
        // 数据库查出待更新对象
        Student studentFindingResult = studentRepository.findByStudentId(studentId);
        if (studentFindingResult == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        // 使用hutool BeanUtil进行对象拷贝（忽略null值）
        BeanUtil.copyProperties(student, studentFindingResult, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        // 执行更新操作
        Student studentResult = studentRepository.save(studentFindingResult);
        return  studentResult;
    }



    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/21 05:05
     * @description： 教师登录
     * @version:     1.0.0
     */

    @Override
    public Teacher teacherLogin(String code) throws BusinessException {
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

        // 通过openid查询教师信息
        Teacher teacherResult = teacherRepository.findByOpenid(openid);

        return teacherResult;
    }


    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/21 05:05
     * @description： 学生登录
     * @version:     1.0.0
     */

    @Override
    public Student studentLogin(String code) throws BusinessException {
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

        // 通过openid查询教师信息
        Student studentResult = studentRepository.findByOpenId(openid);

        return studentResult;
    }



    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/21 05:17
     * @description： 学生绑定
     * @version:     1.0.0
     */
    @Override
    public Student studentBinding(Student student) throws BusinessException {

        Student studentResult = studentRepository.findByStudentAccountAndAndStudentNameAndStudentPassword(
                student.getStudentAccount(), student.getStudentName(), student.getStudentPassword()
        );
        if (studentResult == null) throw new BusinessException(EnumBusinessError.TEACHER_NOT_EXIST);
        // 把openId写入数据库
        Student studentResultAfterAddingOpenid = studentRepository.save(student);
        return studentResultAfterAddingOpenid;
    }


    /**
     * @author     ：xyy
     * @date       ：Created in 2019/12/21 01:13
     * @description： 教师修改密码
     * @version:     1.0.0
     */

    @Override
    public Teacher updateTeacherPassword(int teacherId, String password) throws BusinessException {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(teacherId);
        teacher.setTeacherPassword(password);
        // 数据库查出待更新对象
        Teacher teacherFindingResult = teacherRepository.findByTeacherId(teacherId);
        if (teacherFindingResult == null) throw new BusinessException(EnumBusinessError.RECORD_NOT_EXIST);
        // 使用hutool BeanUtil进行对象拷贝（忽略null值）
        BeanUtil.copyProperties(teacher, teacherFindingResult, true, CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
        // 执行更新操作
        Teacher teacherResult = teacherRepository.save(teacher);
        return  teacherResult;
    }
}
