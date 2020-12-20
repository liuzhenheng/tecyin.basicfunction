package com.tecyin.basiclassify.utils;
/**
 * 公共的返回码
 * 返回码resultCode：
 * 成功：10000
 * 失败：10001
 * 未登录：10002
 * 未授权：10003
 * 抛出异常：99999
 */
public enum ResultCode {
    //---系统错误返回码-----
    SUCCESS(true, 200, "成功！"),
    FAIL(false, 300, "失败"),
    UNAUTHENTICATED(false, 500, "您还未登录"),
    //UNAUTHORISE(false,201,"未授权"),
    MAKESURE(false,301,"确定删除"),
    //MOBILEORPASSWORDERROR(false,301,"用户名或密码错误");
    SERVER_ERROR(false, 404, "抱歉，系统繁忙，请稍后重试！");

    //---用户操作返回码  2xxxx----
    //---企业操作返回码  3xxxx----
    //---权限操作返回码----
    //---其他操作返回码----

    //操作是否成功
    boolean success;
    //操作代码
    int resultCode;
    //提示信息
    String con;

    ResultCode(boolean success, int resultCode, String con) {
        this.success = success;
        this.resultCode = resultCode;
        this.con = con;
    }

    public boolean success() {
        return success;
    }

    public int resultCode() {
        return resultCode;
    }

    public String con() {
        return con;
    }

}
