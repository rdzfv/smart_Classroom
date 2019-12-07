package com.zjut.smartClassroom.error;

/**
 * @author ：xyy
 * @date ：Created in 2019/08/23 12:45:23
 * @description：EnumBusinessError
 * @modified By：xyy in 2019/12/04 16:53:28
 * @version: 1.0.0
 */
public enum EnumBusinessError implements CommonError {
    // 00002 未知错误
    UNKNOWN_ERROR(10002, "未知错误"),


    // 10001 通用错误类型
    PARAMETER_VALIDATION_ERROR(10001, "参数不合法"),


    // 10002 传入参数为空值
    PARAMETER_IS_NULL(10002, "传入参数为空值"),


    // 20000 开头为用户信息相关错误定义
    USER_NOT_VALIDATE(20001, "用户身份验证未通过"),
    USER_ACCOUNT_ISARREARAGE(20003, "会员身份验证合法，但已欠费"),


    // 30000 开头为数据库执行操作相关错误定义
    UPDATE_FAILED(30001, "更新操作失败"),
    FIND_FAILED(30002, "查询不存在的记录"),
    DELETE_FAILED(30003, "删除不存在的记录"),
    ADD_FAILED(30004, "添加有误，请检查输入"),
    RECORD_NOT_EXIST(30005, "记录不存在，请检查输入"),
    COURSE_NOT_EXIST(30006, "课程不存在，请检查输入"),
    PAPER_NOT_EXIST(30007, "练习卷不存在，请检查输入"),
    TEACHER_NOT_EXIST(30008, "教师不存在，请检查输入");

    private EnumBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private int errCode;
    private String errMsg;

    @Override
    public int getErrorCode() {
        return this.errCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
