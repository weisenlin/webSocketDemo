package com.socket.dto;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * create by WSL_SILVA
 * 日期: 2018/7/26 0026
 * 用途：
 * 描述:
 */
public class UserDto implements Serializable{

    @NotEmpty(message = "邮件不能为空")
    private String email;

    @NotEmpty(message = "密码不能为空")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
