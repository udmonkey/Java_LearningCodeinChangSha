<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2020/6/14
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Jdbc_login01</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/users">
    登录名：   <input type="text" name="username">
    密码：     <input type="text" name="password">
              <input type="hidden" name="method" value="login">
              <input type="submit" value="登陆">

  </form>
  </body>
</html>
