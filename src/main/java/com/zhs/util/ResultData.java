package com.zhs.util;

import lombok.Data;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/13 15:05
 * 描述: 统一返回接口数据格式
 * */
@Data
public class ResultData {

    private Integer code;

    private String message;

    private boolean success;

    private Object data;

    public ResultData(Integer code, String message, boolean success, Object data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }



    public static ResultData ofSuccess(Object data) {
        return new ResultData(200, "成功", true, data);
    }

    public static ResultData ofFail(String errorMsg) {
        return new ResultData(100, errorMsg, false, null);
    }

    //public static ResultData ofFail(String errorMsg,Object data) {
     //   return new ResultData(100, errorMsg, false, data);
 //   }
}
