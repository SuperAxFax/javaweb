<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/3/14
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<%
    Object user_session = request.getSession().getAttribute("USER_SESSION");
    if(user_session==null){
       response.sendRedirect("/Login.jsp");
    }

%>--%>
<h1>主页</h1>
<%--思考如何在访问sys文件夹的时候不让其进入主页--%>
<p><a href="/servlet/logout">注销</a></p>
</body>
</html>
