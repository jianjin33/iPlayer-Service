package com.iplayer.media.util;

import org.springframework.context.MessageSource;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * 返回信息工具类
 */
public class MessageUtils {

    private static MessageUtils messageUtil=null;
    @Resource
    private MessageSource messageSource;

    private MessageUtils(){
        messageSource = (MessageSource)SpringBeanFactoryUtils.getBean("messageSource");
    }

    public static MessageUtils getInstance(){
        if (messageUtil == null) {
            synchronized(MessageUtils.class) {
                if (messageUtil == null)
                    messageUtil = new MessageUtils();
            }
        }
        return messageUtil;
    }
    /**
     * 获取当前key对应的文字信息
     * @param key
     * @return
     */
    public String getMessage(String key) {
        return messageSource.getMessage(key, new Object[]{}, Locale.CHINA);
    }
    /**
     * 获取当前key对应的文字信息
     * @param key
     * @param args
     * @return
     */
    public String getMessage(String key, Object[] args) {
        return messageSource.getMessage(key, args, Locale.CHINA);
    }
}
