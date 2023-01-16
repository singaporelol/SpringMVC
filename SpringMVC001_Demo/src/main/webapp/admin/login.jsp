<%--
  Created by IntelliJ IDEA.
  User: weiji
  Date: 31/12/2022
  Time: 12:24 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--request.setAttribute("requestUsers",u);--%>
<%--session.setAttribute("sessionUsers",u);--%>
<%--model.addAttribute("modelUsers",u);--%>
<%--map.put("mapUsers",u);--%>
<%--modelMap.addAttribute("modelMapUsers",u);--%>

    <h1>login 页面</h1>
requestUsers:${requestUsers}<br/>
sessionUsers:${sessionUsers}<br/>
modelUsers:${modelUsers}<br/>
mapUsers:${mapUsers}<br/>
modelMapUsers:${modelMapUsers}<br/>
msg:${msg}<br/>
从页面携带来的数据：${param.sex}
<form action="${pageContext.request.contextPath}/login" method="get">
    <input type="input" name="name" value="xueqian" />
    <input type="password" name="pwd" value="123"/>
    <input type="submit" name="submit" value="submit" />
</form>
</body>
</html>
