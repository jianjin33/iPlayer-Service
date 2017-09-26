package com.iplayer.media.filter;

/**
 * Created by Administrator on 2017/9/26.
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequestWrapper extends HttpServletRequestWrapper {
    private Map<String,String> paramMap;

    public MyRequestWrapper(HttpServletRequest request) {
        super(request);
        paramMap =getParameterMap(request);
    }

    /**
     * FIXME 修改后的获取参数方法
     * @param name
     * @return
     */
    public String getParameter(String name){
        return paramMap.get(name);
    }

    /**
     * FIXME 修改参数值的方法
     * @param name
     * @return
     */
    public String updateParameter(String name,String value){
        return paramMap.put(name,value);
    }


    @SuppressWarnings("rawtypes")
    public static Map<String,String> getParameterMap(HttpServletRequest request) {
        // 参数Map
        Map properties = request.getParameterMap();
        // 返回值Map
        Map<String,String> returnMap = new HashMap<String,String>();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = "";
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                for(int i=0;i<values.length;i++){
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }

}