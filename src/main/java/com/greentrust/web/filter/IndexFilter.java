package com.greentrust.web.filter;

import com.auth0.jwt.internal.org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description:
 * @author:Yangk.
 * @create:2018-04-04 14:38
 */
@Component
@WebFilter(urlPatterns = "/*")
public class IndexFilter implements Filter {

    private static String ajaxHeader = "XMLHttpRequest";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("IndexFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        //  该if判断用于判断是否为ajax请求
        if (StringUtils.equals(request.getHeader("X-Requested-With"),ajaxHeader)) {
            System.out.println("接收到ajax异步请求");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.print("=========================destroy========================");

    }

}
