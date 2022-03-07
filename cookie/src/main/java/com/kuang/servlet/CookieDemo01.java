package com.kuang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
/*该程序逻辑：
* 1：如果要访问这个实体类
* 2：首先从请求中拿到cookie
* 3：如果cookie中有lastLoginTime这样一个键值对。我们就把它的值给取出来。
* 4：如果没有的话就会告诉你这是你第一次访问本站，然后给你一个新的cookie值。
* */



//保存用户上一次访问的时间
public class CookieDemo01 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //服务器告诉你你来的时间，把这个时间封装成一个信件，你下次带来，我就知道你来了
        //解决中文乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();

        //Cookie，服务器从客户端获取。用户去请求的时候，带上你的小饼干。
        Cookie[] cookies = req.getCookies();

        //判断Cookie是否存在
        if(cookies!=null){
            //这是存在的情况，应如何处理
            out.write("你上一次访问的时间是：");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                //获取cookie的名字
                if(cookie.getName().equals("lastLoginTime")){
                    //获取cookie中的值
                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginTime);
                    out.write(date.toString());

                }
            }

        }else{
            out.write("这是您第一次访问本站");
        }

        //如果不存在，服务器给客户端响应一个cookie
        Cookie cookie = new Cookie("name", System.currentTimeMillis()+"");
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
