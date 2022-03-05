package com.kuang.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1：要获取下载文件的路径
        //C:\JavaWeb\JavaWeb-01-servlet\response\target\response-1.0-SNAPSHOT\WEB-INF\classes
        //要下载的路径：C:\JAVA\abo\apache-tomcat-7.0.108\webapps\fax\1.jpg
        String realPath = "C:\\JavaWeb\\JavaWeb-01-servlet\\response\\target\\response-1.0-SNAPSHOT\\WEB-INF\\classes\\阿想.jpg";
        System.out.println("要下载的路径："+realPath);
        //2：下载的文件名是啥（这是十分精巧的一个方法）substring是截取字符串的作用！
        String filename = realPath.substring(realPath.lastIndexOf("//") + 1);
        //3：想办法设置让浏览器能够支持下载我们需要的东西
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(filename,"UTF-8"));
        //4：获取下载文件的输入流(把文件变成流)
        FileInputStream in = new FileInputStream(realPath);
        //5：创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        //6：获取OutputStream对象
        ServletOutputStream out = resp.getOutputStream();
        //7：将FileOutputStream流写入到buffer缓冲区,并使用OutputStream将缓冲区中的数据输出到客户端
        while((len=in.read(buffer))>0){
            out.write(buffer,0,len);
        }
        //8：关闭流
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
