<%--
  Created by IntelliJ IDEA.
  User: weiji
  Date: 9/1/2023
  Time: 1:55 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/hello" method="get">
    用户名：<input name="username" value="xueqian"/>
    密码：<input type="password" name="password" value="123" />
    提交按钮：<input type="submit" value="提交22">
  </form>
  </body>
</html>
