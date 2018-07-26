package com.socket.controller;

import com.socket.dto.UserDto;
import com.socket.result.Result;
import com.socket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * create by WSL_SILVA
 * 日期: 2018/7/26 0026
 * 用途：
 * 描述:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    @ResponseBody
    public Result register(@Valid UserDto userDto, BindingResult bindingResult){
        Result result = new Result(200,"注册成功，请登录");
        if(bindingResult.hasErrors()){
            result.setCode(401);
            result.setMessage("表单验证失败");
            result.setData(bindingResult.getAllErrors());
        }
        //查找该邮箱是否已存在用户
        if(userService.findByEmail(userDto.getEmail())!=null){
            result.setMessage("该邮箱已注册");
        }else{
            userService.save(userDto);
        }
        return result;
    }
}
