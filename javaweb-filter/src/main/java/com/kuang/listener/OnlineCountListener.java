package com.kuang.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


//统计在线人数：也就是统计Session
public class OnlineCountListener implements HttpSessionListener {
    //创建Session监听：看你的一举一动
    //一旦创建Session就会触发一次这个事件
    @Override
    public void sessionCreated(HttpSessionEvent se) {

        ServletContext ctx = se.getSession().getServletContext();
        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");

        if(onlineCount==null){
            onlineCount = new Integer(1);
        }else{
            int count = onlineCount.intValue();
            onlineCount = new Integer(count + 1);
        }
        ctx.setAttribute("OnlineCount",onlineCount);

    }

    //销毁所有的session监听
    //一旦销毁Session就会触发一次这个事件！
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        ServletContext ctx = se.getSession().getServletContext();
        Integer onlineCount = (Integer) ctx.getAttribute("OnlineCount");

        if(onlineCount==null){
            onlineCount = new Integer(0);
        }else{
            int count = onlineCount.intValue();
            onlineCount = new Integer(count - 1);
        }
        ctx.setAttribute("OnlineCount",onlineCount);
    }


    /*
    * session销毁的两种方式：
    * 1：手动销毁：se.getSession().invalidate();
    * 2: 自动销毁：在web.xml中配置过期时间：
    * <session-config>
      <session-timeout>1</session-timeout>
      </session-config>
    * */
}
