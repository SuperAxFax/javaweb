<%--
  Created by IntelliJ IDEA.
  User: 27870
  Date: 2022/3/9
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--请求转发--%>
<%--http://localhost:8080/jsptag.jsp?name=fax&age=12--%>
<jsp:forward page="index.jsp">
    <%--转发的时候使用标签的形式携带参数--%>
    <jsp:param name="name" value="fax"></jsp:param>
    <jsp:param name="age" value="18"></jsp:param>
</jsp:forward>


</body>
</html>
