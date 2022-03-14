package com.kuang.filter;

import com.mysql.fabric.xmlrpc.base.ResponseParser;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    //初始化：web服务器启动的时候就已经初始化了，因为他要它要随时等待过滤对象的出现！
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("CharacterEncodingFilter初始化");
    }

    //Chain:链的意思
    /*

    1：过滤经过的所有代码，在有过滤请求的时候执行！
    2：必须要让过滤器同时执行!
    Chain.doFilter(Request,Response);
    * */
    @Override
    public void doFilter(ServletRequest Request, ServletResponse Response, FilterChain Chain) throws IOException, ServletException {

        Request.setCharacterEncoding("utf-8");
        Response.setCharacterEncoding("utf-8");
        Response.setContentType("text/html;charset=utf-8");

        System.out.println("该程序执行前！");
        Chain.doFilter(Request,Response);//这句话是让我们的请求继续走下去，，如果不写，程序就会被拦截停止。
        System.out.println("该程序执行后！");
    }


    //销毁：web服务器关闭的时候，过滤器会销毁！
    @Override
    public void destroy() {

        System.out.println("CharacterEnncodingFilter销毁");
    }
}
