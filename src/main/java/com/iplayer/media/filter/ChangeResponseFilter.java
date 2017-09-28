package com.iplayer.media.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/9/26.
 */
public class ChangeResponseFilter implements Filter {

    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        System.out.print("header值：" + ((HttpServletRequest) request).getHeader("iplayer"));
//        if ("iplayer".equals(((HttpServletRequest) request).getHeader("iplayer"))) {
            chain.doFilter(request,response);
//        }

    }

    public void init(FilterConfig arg0) throws ServletException {

    }

}