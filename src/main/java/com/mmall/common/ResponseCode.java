package com.mmall.common;

/**
 * Created by Yelun on 2017/5/24.
 */
public enum ResponseCode {
    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT"),
    NEED_LOGIN(10,"NEED_LOGIN");

    private final int code;
    private final String desc;


    private ResponseCode(int code,String desc){
        this.code = code;
        this.desc =desc;
    }

    public int getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }
}
