<%--
  Created by IntelliJ IDEA.
  User: weiji
  Date: 29/12/2022
  Time: 4:12 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.4.1.js"></script>
</head>
<body>
<a href="${pageContext.request.contextPath}/demo.action">访问服务器</a>
<hr/>
<form action="${pageContext.request.contextPath}/req3.action" method="get">
    username:<input name="username" value="张三3"/><br/>
    password: <input name="password" value="password001"/> <br/>
    age:<input name="age" value="18"/><br/>
    提交：<input type="submit" name="get提交"/>
</form>
<hr/>
<form action="${pageContext.request.contextPath}/req3.action" method="post">
    username:<input name="username" value="李四"/><br/>
    password: <input name="password" value="password002"/> <br/>
    age:<input name="age" value="19"/><br/>
    提交：<input type="submit" name="post提交"/>
</form>
<hr/>
<a href="${pageContext.request.contextPath}/req2/zhangsan/20.action">Restful风格，动态占位符</a>
<hr/>

<a href="javascript:showUsers()">访问服务器拿到用户集合</a>
<div id="mydiv">用户列表数据会在这里显示：</div>
<hr/>
请求转发和重定向：
<a href="${pageContext.request.contextPath}/req6.action">请求转发页面</a>
<a href="${pageContext.request.contextPath}/req7.action">请求转发action</a>
<a href="${pageContext.request.contextPath}/req8.action">重定向页面</a>
<a href="${pageContext.request.contextPath}/req9.action">重定向action</a>

测试页面数据的传递：（点击链接，进行服务器跳转页面，在跳转的页面查询数据。）<br/>
测试了请求转发和页面跳转。<br/>
<a href="/req10.action?sex=Male">测试页面数据传递</a>
<script type="text/javascript">
    function showUsers() {
        $.ajax({
            url: "${pageContext.request.contextPath}/req5.action",
            type: "get",
            dataType: "json",
            success: (userList) => {
                var s = "";
                userList.forEach(u => {
                    s += u.username + "--" + u.age + "<br/>";
                })
                $("#mydiv").html(s);
            }
        })
    }

</script>
<hr/>
<form action="${pageContext.request.contextPath}/req11.action" method="get">
    <input type="date" name="date" />
    <input type="submit" name="submit" value="submit" />
</form>


</body>
</html>
