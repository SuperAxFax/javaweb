<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    //实现转发功能，前端可以这样写
    //要是后台要写成request.getRequestDispatcher("/index.jsp").forward(request,response);
    //两个效果一样
    pageContext.forward("/index.jsp");
%>

</body>
</html>
