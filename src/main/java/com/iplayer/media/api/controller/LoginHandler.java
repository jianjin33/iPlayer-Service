package com.iplayer.media.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jianzuming on 17/9/24.
 *
 */

@Controller
public class LoginHandler {

    @RequestMapping("/login.do")
    public String login(String account, String password, HttpServletRequest httpRequest){
        System.out.printf("我进来了");
        return "index";
    }
}