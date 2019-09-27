package com.lanxin.util;

public class Result {

    //结果码
    private String code;
    //结果码描述
    private String msg;
    //结果码枚举
    private Object data;

    public static Result success() {
        Result result = new Result();
        result.setCode("200");
        result.setMsg("执行成功");
        return result;
    }

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode("200");
        result.setMsg("执行成功");
        result.setData(object);
        return result;
    }

    public static Result failed() {
        Result result = new Result();
        result.setCode("500");
        result.setMsg("程序内部异常");
        return result;
    }

    public static Result failed(String code, String msg) {
        Result result = new Result();
        result.setCode("500");
        result.setMsg("程序内部异常");
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
