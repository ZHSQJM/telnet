package com.zhs.util;

public class ResultDataUtil {

    //返回成功的api 自定义返回信息
    public static  ResultData success(String msg,Object object){
        ResultData resultData=new ResultData();
        resultData.setCode(200);
        resultData.setMsg(msg);
        resultData.setObj(object);
        return  resultData;
    }

    public static  ResultData success(Object object){
        ResultData resultData=new ResultData();
        resultData.setCode(200);
        resultData.setMsg("查询成功");
        resultData.setObj(object);
        return  resultData;
    }

    //返回错误的api
    public  static  ResultData error(String msg,Object object){
        ResultData resultData=new ResultData();
        resultData.setCode(500);
        resultData.setMsg(msg);
        resultData.setObj(object);
        return  resultData;
    }

    public  static  ResultData error(Object object){
        ResultData resultData=new ResultData();
        resultData.setCode(500);
        resultData.setMsg("查询失败");
        resultData.setObj(object);
        return  resultData;
    }
}
