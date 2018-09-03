package com.greentrust.web.adapter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author:Yangk.
 * @create:2018-04-04 15:34
 */

public class UserInterceptor  implements HandlerInterceptor {
//以下是我在别处找到的过滤器与拦截器的不同之处
//最大的区别是Filter过滤器可以作用于Servlet及Controller。而拦截器无法拦截到发送至Servlet中的请求，只能拦截到Controller中的。
// 拦截器是基于动态代理的，而过滤器是基于函数回调。
// 拦截器不依赖于servlet容器，通过动态代理实现，过滤器依赖于servlet容器。
// 拦截器可以在方法前后，异常前后等调用，而过滤器只能在请求前和请求后各调用一次。
// 拦截器可以利用依赖注入，因此在Spring框架程序中，优先拦截器。

    /**
     * controller 执行之前调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("------preHandle-----");
        return true;
    }

    /**
     * controller 执行之后，且页面渲染之前调用
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("------postHandle-----");
    }

    /**
     * 页面渲染之后调用，一般用于资源清理操作
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("------afterCompletion-----");

    }
}


