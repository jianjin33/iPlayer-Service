package com.iplayer.media.util;

/**
 * Created by Administrator on 2017/9/25.
 */
public class Utils {


    /**
     * 判断字符串是否为空
     *
     * @param target
     * @return true 空字符串
     */
    public static boolean $(String target) {
        return target == null || (target.trim()).length() == 0;
    }


    public static boolean isEquals(Object a, Object b) {
        return a == null || b == null ? false : a.equals(b);

    }

    public static boolean isNotEquals(Object a, Object b) {
        return a == null || b == null ? true : !a.equals(b);
    }

}
