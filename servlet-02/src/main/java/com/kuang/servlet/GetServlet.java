package com.kuang.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //接下来来取ServletContext中的数据；
        ServletContext context = this.getServletContext();
        String attribute = (String) context.getAttribute("fax");

        //接下来的这句是来解决网页出现??null问题的
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");


        //接下来是响应流，没有响应流网页上就看不到数据
        PrintWriter writer = resp.getWriter();
        writer.print("名字"+attribute);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
