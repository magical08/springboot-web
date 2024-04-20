package com.itheima.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * ClassName:DemoFilter
 * Package:com.itheima.filter
 * Description:
 *
 * @Author zhuzhu
 * @Create 2024/4/10 16:55
 * @Version 1.0
 */
//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {

    @Override  //初始化的方法，只被调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("inti 初始化方法执行了");
    }

    @Override  //拦截到请求之后调用，调用多次
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Demo拦截到请求了...放行前的逻辑");
        //放行
        chain.doFilter(request,response);
        System.out.println("Demo拦截到请求了...放行后的逻辑");
    }

    @Override   //销毁方法，只被调用一次
    public void destroy() {
        System.out.println("destroy 销毁方法执行了");
    }
}
