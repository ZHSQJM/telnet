package com.zhs.util;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/13 15:05
 * 描述: 统一返回接口数据格式
 * */
public class AjaxResult {

    private Integer code;

    private String message;

    private boolean success;

    private Object data;

    public AjaxResult(Integer code, String message, boolean success, Object data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public static AjaxResult of(HttpStatus status, Object data) {
        boolean isSuccess = 200 == status.getCode() ? true : false;
        return new AjaxResult(status.getCode(), status.getMessage(), isSuccess, data);
    }

    public static AjaxResult ofSuccess(Object data) {
        return new AjaxResult(200, "成功", true, data);
    }

    public static AjaxResult ofFail(String errorMsg) {
        return new AjaxResult(100, errorMsg, false, null);
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
