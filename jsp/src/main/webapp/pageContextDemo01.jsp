<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--内置对象--%>
<%
    pageContext.setAttribute("name1","fax1");//保存的数据只在一个页面中有效
    request.setAttribute("name2","fax2");//保存的数据只在一次请求转发中有效，请求转发会携带这个数据
    session.setAttribute("name3","fax3");//保存的数据只在一次会话中有效，从打开浏览器到关闭浏览器
    application.setAttribute("name4","fax4");//保存的数据只在服务器中有效，从打开服务器到关闭服务器，因此这个保存时间最长

%>

<%--脚本片段中的代码，会被原封不动的生成到.JSP.java
要求：这里面的代码：必须要保证Java语法的正确性
--%>

<%
   //从pageContext中取出，我们通过寻找的方式来得到Attribute
    //它寻找的路径是从底层到高层：page-->request-->session-->application
    String nama1 = (String) pageContext.findAttribute("nama1");
    String name2 = (String) pageContext.findAttribute("name2");
    String name3 = (String) pageContext.findAttribute("name3");
    String name4 = (String) pageContext.findAttribute("name4");
    String name5 = (String) pageContext.findAttribute("name5");

    pageContext.forward("/pageContextDemo02.jsp");

%>

<%--使用EL表达式输出 ${}--%>

<h1>取出的值为：</h1>
<h1>${name1}</h1>
<h1>${name2}</h1>
<h1>${name3}</h1>
<h1>${name4}</h1>
<h1>${name5}</h1>

<h1><%=name5%></h1>
</body>
</html>
