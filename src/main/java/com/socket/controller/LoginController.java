package com.socket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by WSL_SILVA
 * 日期: 2018/7/26 0026
 * 用途：
 * 描述:
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping("")
    public String login(){

        return "/windows/login";
    }
}
