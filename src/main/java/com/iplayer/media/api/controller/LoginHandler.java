package com.iplayer.media.api.controller;

import com.iplayer.media.api.function.IUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianzuming on 17/9/24.
 * 用户登录注册修改密码
 */

@Controller
public class LoginHandler {

    @Autowired
    IUserServer userServer;

    @ResponseBody
    @RequestMapping(value = "login")
    public Map<String, Object> login(String account, String password, HttpServletRequest httpRequest) {
        System.out.println("account:" + account + ";password:" + password);
        try {
            Map map = userServer.login(account, password);
            System.out.printf("login返回值：" + map);
            return map;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}