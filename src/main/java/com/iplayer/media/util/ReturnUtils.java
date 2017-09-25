package com.iplayer.media.util;
import com.iplayer.media.core.Constants;
import org.apache.commons.beanutils.PropertyUtilsBean;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据工具类
 */
public class ReturnUtils {
    /**
     * 接口调用返回编码
     */
    private static final String returnCode = "code";
    /**
     * 接口调用返回信息描述
     */
    private static final String returnMessage = "message";

    /**
     * 返回数据增加操作成功编码及操作信息
     * @param data
     * @returns
     */
    public static Map<String, Object> returnMess(Map<String, Object> data) {
        data.put(returnCode, Constants.RESULT_CODE_SUCCESS);
        data.put(returnMessage, MessageUtils.getInstance().getMessage(Constants.RESULT_CODE_SUCCESS));
        return data;
    }

    /**
     * 系统错误返回错误编码及相对应操作信息
     *
     * @return
     */
    public static Map<String, Object> returnMess(String code) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put(returnCode, code);
        data.put(returnMessage, MessageUtils.getInstance().getMessage(code));
        return data;
    }

    /**
     * 系统错误返回错误编码及相对应操作信息
     *
     * @return
     */
    public static Map<String, Object> returnMess(String code, String message) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put(returnCode, code);
        data.put(returnMessage, message);
        return data;
    }

    /**
     * 返回数据及操作编码
     *
     * @param data 返回数据
     * @param code 错误编码
     * @return
     */
    public static Map<String, Object> returnMess(Map<String, Object> data, String code) {
        data.put(returnCode, code);
        data.put(returnMessage, MessageUtils.getInstance().getMessage(code));
        return data;
    }

    //将javabean实体类转为map类型，然后返回一个map类型的值
    public static Map<String, Object> beanToMap(Object obj) {
        Map<String, Object> params = new HashMap<String, Object>(0);
        try {
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj);
            for (int i = 0; i < descriptors.length; i++) {
                String name = descriptors[i].getName();
                if (!"class".equals(name)) {
                    params.put(name, propertyUtilsBean.getNestedProperty(obj, name));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }

}
