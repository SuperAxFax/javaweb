<%@ page import="javax.xml.bind.SchemaOutputResolver" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<%--JSP表达式
作用：用来将程序的输出，输出到客户端
<%= 变量或者表达式%>
--%>
<%= new java.util.Date()%>
<hr>

<%--jsp脚本片段--%>
<%
    int sum = 0;
    for(int i=1;i<=100;i++){
        sum+=i; }
        out.println("<h1>Sum="+sum+"</h1>");
%>

<%
    int x = 10;
    out.println(x);
%>
<p>这是一个JSP文档</p>
<%
    int y = 2;
    out.println(y);
%>

<%--在代码中嵌入HTML元素
<%=i%>也可以使用${}}
--%>
<%
    for(int i = 0; i < 5; i++){
%>
    <h1>Hello,World <%=i%>></h1>
<%
    }
%>


<%!
   static{
       System.out.println("Loading Servlet!");
   }

   private int flobalVar = 0;
   public void kuang(){
       System.out.println("进入了方法kuang!");
   }
%>



<%--取出jsptag.jsp的参数--%>
名字：<%=request.getParameter("name")%>
年龄：<%=request.getParameter("age")%>
</body>
</html>
