package com.zhs.enums;

/**
 * Created with IDEA
 * author:周华生
 * Date:2018/8/13 15:03
 * 描述:枚举类  判断账号的状态
 **/
public enum StatusEnum {

    ON(1), OFF(0), DEL(-1);

    private int code;

    StatusEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
