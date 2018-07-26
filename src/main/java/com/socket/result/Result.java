package com.socket.result;

import java.io.Serializable;

/**
 * create by WSL_SILVA
 * 日期: 2018/7/26 0026
 * 用途：
 * 描述:
 */
public class Result<T> implements Serializable{

    private Integer code;

    private String message;

    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
