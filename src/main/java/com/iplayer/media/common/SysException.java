package com.iplayer.media.common;

/**
 * Created by Administrator on 2017/9/25.
 */
public class SysException extends RuntimeException {
    public SysException(String message) {
        super(message);
    }

    public SysException(String message, Throwable cause) {
        super(message, cause);
    }


}
