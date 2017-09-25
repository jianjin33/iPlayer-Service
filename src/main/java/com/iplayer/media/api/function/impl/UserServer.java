package com.iplayer.media.api.function.impl;

import com.iplayer.media.api.dao.LoginDao;
import com.iplayer.media.api.entity.UserBean;
import com.iplayer.media.api.function.IUserServer;
import com.iplayer.media.core.Constants;
import com.iplayer.media.util.ReturnUtils;
import com.iplayer.media.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.iplayer.media.util.Utils.$;

/**
 * Created by jianzuming on 17/9/24.
 * 用户操作业务逻辑层
 */

@Service
public class UserServer implements IUserServer {

    @Autowired
    LoginDao mLoginDao;

    /**
     * 用户登录操作
     *
     * @param account
     * @param password
     * @return
     */

    @Override
    public Map<String, Object> login(String account, String password) {
        Map<String, Object> data = new HashMap<String, Object>();
        if ($(account) || $(password))
            return ReturnUtils.returnMess(Constants.RESULT_CODE_LOGIN_ERROR);
        try {
            UserBean userBean = mLoginDao.select("account", account);

            if (userBean == null)
                return ReturnUtils.returnMess(Constants.RESULT_USER_NOT_EXIST);

            if (Utils.isNotEquals(password, userBean.getPassword()))
                return ReturnUtils.returnMess(Constants.RESULT_CODE_LOGIN_PWD_ERROR);

            data.put("vip", userBean.getVip());
            data.put("userName", userBean.getAccount());

            return ReturnUtils.returnMess(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ReturnUtils.returnMess(Constants.RESULT_CODE_LOGIN_ERROR);
    }


    /**
     * 用户注册
     *
     * @param account
     * @param password
     * @param code 验证码
     * @return
     */
    @Override
    public Map register(String account, String password, String code) throws Exception {

        if ($(account) || $(password))
            return ReturnUtils.returnMess(Constants.RESULT_CODE_NOT_REGISTER_ERROR);

        UserBean userBean = mLoginDao.select("account", account);
        if (userBean != null && Utils.isEquals(account, userBean.getAccount()))
            return ReturnUtils.returnMess(Constants.RESULT_CODE_REGISTER_ERROR);

        UserBean bean = new UserBean();
        bean.setAccount(account);
        bean.setPassword(password);
        bean.setVip("N");

        mLoginDao.insert(bean);
        return ReturnUtils.returnMess(Constants.RESULT_CODE_SUCCESS);
    }
}
