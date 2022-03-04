package com.kuang.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();

        RequestDispatcher requestDispatcher = context.getRequestDispatcher("/initpara");//转发的请求路径
        requestDispatcher.forward(req,resp);//调用forward方法实现请求转发
       /* resp.getWriter().print("现在进入的是sd4界面！");
        //经过测试得知，请求转发的优先级比自己界面输出的优先级要高！*/
        System.out.println("进入了sd4界面");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
