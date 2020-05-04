<%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 01.05.2020
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<br>
<head>
    <title>RegisterNewUser</title>
</head>
<p><font color ="red">${error}</font></p>
<form action="RegisterServlet" method="post">
    Name new user: <input type="text" name="nameNewUser"></br>
    Password new user: <input type="password" name="passwordNewUser"></br>
    <br>
    <input type="submit" value="register">
</form>
</body>
</html>
