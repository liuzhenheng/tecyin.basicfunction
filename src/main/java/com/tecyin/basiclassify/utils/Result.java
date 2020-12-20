package com.tecyin.basiclassify.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data//提供getter、setter方法
@NoArgsConstructor//无参构造
public class Result {
    private int resultCode;//状态码

    private String con;//消息

    private Object data;//数据

    private boolean success;


    //不需要返回数据时使用
    public Result(ResultCode resultCode) {
        this.success = resultCode.success;
        this.resultCode = resultCode.resultCode;
        this.con = resultCode.con;
    }

    public Result(ResultCode resultCode, Object data) {
        this.success = resultCode.success;
        this.resultCode = resultCode.resultCode;
        this.con = resultCode.con;
        this.data = data;
    }

    public Result(Integer resultCode, String con, boolean success) {
        this.resultCode = resultCode;
        this.con = con;
        this.success = success;
    }

    /*
     * 调用ResultCode类封装常用的返回数据
     */
    public static Result SUCCESS() {
        return new Result(ResultCode.SUCCESS);
    }

    public static Result ERROR() {
        return new Result(ResultCode.SERVER_ERROR);
    }

    public static Result FAIL() {
        return new Result(ResultCode.FAIL);
    }

    public static Result MAKESURE() {
        return new Result(ResultCode.MAKESURE);
    }
}
