package com.kuang.servlet;

import com.kuang.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //得到Session
        HttpSession session = req.getSession();
        //给Session中存东西
        session.setAttribute("name",new Person("阿想",16));
        //获取Seesion的ID
        String id = session.getId();
        //判断Session是不是新建的
        if(session.isNew()){
            resp.getWriter().write("session创建成功，ID："+id);
        }else{
            resp.getWriter().write("'session在服务器中已经存在，ID："+id);
        }

       /* //Session创建的时候做了什么事情
        Cookie cookie = new Cookie("JSESSIONID", id);
        resp.addCookie(cookie);
*/

    }
        @Override
        protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        }
    }