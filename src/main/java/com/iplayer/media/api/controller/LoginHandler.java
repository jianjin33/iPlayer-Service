package com.iplayer.media.api.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.iplayer.media.api.function.IUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by jianzuming on 17/9/24.
 *
 */

@Controller
public class LoginHandler {

    @Autowired
    IUserServer userServer;

    @ResponseBody
    @RequestMapping(value = "login.do")
    public Map<String,Objects> login(String account, String password, HttpServletRequest httpRequest){
        System.out.printf("我进来了1");
        System.out.println(account + "account" + password);
        System.out.printf("我进来了2");
        try {
            Map map = userServer.login(account,password,httpRequest);
            System.out.printf("我进来了3" + map);
            return map;

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }
}