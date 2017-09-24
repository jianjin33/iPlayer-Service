package com.iplayer.media.api.function.impl;

import com.iplayer.media.api.dao.LoginDao;
import com.iplayer.media.api.entity.UserBean;
import com.iplayer.media.api.function.IUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianzuming on 17/9/24.
 */

@Service
public class UserServer implements IUserServer {

    @Autowired
    LoginDao mLoginDao;

    /**
     * 接口调用返回编码
     */
    private static final String returnCode = "code";
    /**
     * 接口调用返回信息描述
     */
    private static final String returnMessage = "message";

    @Override
    public Map login(String account, String password,HttpServletRequest httpRequest) {
        Map<String,Object> data =new HashMap<String,Object>();
        if ("".equals(account) || "".equals(password))
            return (Map) data.put(returnMessage,"用户名或密码为空");

        try {
            UserBean userBean = mLoginDao.select("user_name",account);

            if (userBean == null)
                return (Map) data.put(returnMessage,"用户不存在，请检测！");

            if (!password.equals(userBean.getUser_pwd()))
                return (Map) data.put(returnMessage,"用户名密码不正确，请重试！");

            data.put(returnMessage,"登录成功");
            data.put(returnCode,"000000");
            data.put("vip",userBean.getUser_vip());
            data.put("userName",userBean.getUser_name());

            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
