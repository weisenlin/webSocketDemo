package com.socket.Enum;

/**
 * create by WSL_SILVA
 * 日期: 2018/7/26 0026
 * 用途：
 * 描述:
 */
public enum UserStatusEnum {
    USER_ON_USE(1,"使用"),
    USER_STOP(2,"暂停使用");


    private Integer code;
    private String message;

    UserStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }
}
