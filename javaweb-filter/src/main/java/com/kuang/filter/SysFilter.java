package com.kuang.filter;

import com.kuang.util.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest Req, ServletResponse Resp, FilterChain Chain) throws IOException, ServletException {
       /*如果游戏中有不同的等级该如何进行操作
       if(req.getSession().setAttribute.Constant.USER_SESSION().level==VIP1{
          response.sendRedirect("/vip1/index.jsp");
       }
       if(req.getSession().setAttribute.Constant.USER_SESSION().level==VIP2{
          response.sendRedirect("/vip2/index.jsp");
       }
       if(req.getSession().setAttribute.Constant.USER_SESSION().level==VIP2{
          response.sendRedirect("/vip2/index.jsp");
       }
       *
       * */

        HttpServletRequest request = (HttpServletRequest) Req;
        HttpServletResponse response = (HttpServletResponse) Resp;

        if(request.getSession().getAttribute(Constant.USER_SESSION)==null){
            response.sendRedirect("/error.jsp");
        }
        Chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
