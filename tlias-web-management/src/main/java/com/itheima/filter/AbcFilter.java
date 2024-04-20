package com.itheima.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * ClassName:AbcFilter
 * Package:com.itheima.filter
 * Description:
 *
 * @Author zhuzhu
 * @Create 2024/4/10 18:07
 * @Version 1.0
 */

//@WebFilter(urlPatterns = "/*")
public class AbcFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Abc拦截到请求了...放行前的逻辑");
        //放行
        chain.doFilter(request,response);
        System.out.println("Abc拦截到请求了...放行后的逻辑");
    }


}
