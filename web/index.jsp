<%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 25.04.2020
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>PageChecksLogin</title>
  </head>
  <body>
  <p><font color="red">${errorMassage}</font></p>
  <form action="MainServlet" method="post">
    <p>Enter the system</p>
    Name: <input type="text" name="nameInputChecksLogin"></br>
    Password: <input type="password" name="passwordInputChecksLogin"><br>
    <input type="submit" value="enter">
  </form>
  <form action="RegisterServlet" method="get">
    <p>Register new user</p>
    <input type="submit" value="register">
  </form>
  </body>
</html>
