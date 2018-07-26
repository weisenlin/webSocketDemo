package com.socket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by WSL_SILVA
 * 日期: 2018/7/23 0023
 * 用途：
 * 描述:
 */
@Controller
@RequestMapping("/")
public class TalkController {

    @RequestMapping("/talk")
    public String index(String id, ModelMap map){
        map.put("id",id);
        return "index";
    }
}
