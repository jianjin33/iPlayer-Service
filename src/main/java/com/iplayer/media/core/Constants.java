package com.iplayer.media.core;

/**
 * Created by Administrator on 2017/9/25.
 * 全局常量
 */
public interface Constants {

    /**
     * 请求成功
     */
     String RESULT_CODE_SUCCESS = "0000";

    /**
     * 数据请求失败
     */
    String RESULT_CODE_ERROR = "0001";

    /**
     * 系统繁忙
     */
    String RESULT_CODE_TIMEOUT = "0002";

    /**
     * 用户登录超时
     */
    String RESULT_CODE_LOGIN_TIMEOUT_ERROR = "1000";

    /**
     * 用户不存在
     */
    String RESULT_USER_NOT_EXIST = "1001";

    /**
     * 用户登录密码错误
     */
    String RESULT_CODE_LOGIN_PWD_ERROR = "1002";

    /**
     * 用户登录失败
     */
    String RESULT_CODE_LOGIN_ERROR = "1003";

    /**
     * 用户注册失败
     */
    String RESULT_CODE_NOT_REGISTER_ERROR = "1100";

    /**
     * 该用户已被注册
     */
    String RESULT_CODE_REGISTER_ERROR = "1101";

    /**
     * 获取手机验证码失败
     */
    String RESULT_VALIDATION_CODE_ERROR = "1102";

    /**
     * 手机验证码填写错误
     */
    String RESULT_VALIDATION_CODE_FILL_ERROR = "1103";

    /**
     * 用户原密码填写错误
     */
    String RESULT_CODE_LOGIN_OLD_PWD_ERROR = "1200";

    /**
     * 用户新密码与原密码不能相同
     */
    String RESULT_USER_OLD_NEW_PWD_ERROR = "1201";

}
