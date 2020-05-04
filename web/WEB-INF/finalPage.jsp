<%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 25.04.2020
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>finalPage</title>
    <style>
        .cont{
            margin-left: 100px;
        }
        .footer{
            position: absolute;
            bottom: 0;
            width: 100%;
            height: 40px;
            background-color: aqua;
            text-align: right;
        }
        .footer .container{
            width: auto;
            max-width: 100%;
            padding: 0 15px;
        }
    </style>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#check1").fadeOut(0);
            $("#check2").fadeOut(0);
            $("#check3").fadeOut(0);
            $("#check4").fadeOut(0);
            $("#p1").mouseover(function (){$("#p1").css("color","blue")});
            $("#p1").mouseout(function(){$("#p1").css("color","black")});
            $("#p1").click(function(){$("#check1").fadeIn(3000)});
            $("#but1").click(function(){$("#check1").fadeOut(3000)});
            $("#p2").mouseover(function (){$("#p2").css("color","blue")});
            $("#p2").mouseout(function(){$("#p2").css("color","black")});
            $("#p2").click(function(){$("#check2").fadeIn(3000)});
            $("#but2").click(function(){$("#check2").fadeOut(3000)});
            $("#p3").mouseover(function (){$("#p3").css("color","blue")});
            $("#p3").mouseout(function(){$("#p3").css("color","black")});
            $("#p3").click(function(){$("#check3").fadeIn(3000)});
            $("#but3").click(function(){$("#check3").fadeOut(3000)});
            $("#p4").mouseover(function (){$("#p4").css("color","blue")});
            $("#p4").mouseout(function(){$("#p4").css("color","black")});
            $("#p4").click(function(){$("#check4").fadeIn(3000)});
            $("#but4").click(function(){$("#check4").fadeOut(3000)});
        })
    </script>
        </head>
<body>
    <div>
        <img src="https://www.kv.by/sites/default/files/user7743/logo_iba_group.jpg" width="100px" height="80px">
    </div>
    <div>
        <ul style="list-style-type: none; padding-left: 10px;margin-bottom: 0" >
            <li class="active"><a href="#">Home</a></li>
        </ul>
        <ul style="list-style-type: none; padding-left: 10px; margin-top: 0; margin-bottom: 0">
            <li><a href="MainServlet">Login</a></li>
        </ul>
        <ul style="list-style-type: none; padding-left: 10px; margin-top: 0">
            <li><a href="LogoutServlet">Logout</a></li>
        </ul>
    </div>

<div class="cont">
<p><font size="10px" color="green">
    Hello ${username}
</font></p>
<br>
<table border="3px dashed black" style="height: 300px; float: left">
    <caption>Group Member</caption>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
    </tr>
    <c:forEach var="i" items="${group}">
        <tr>
            <td>${i.name}</td>
            <td>${i.surname}</td>
            <td>${i.email}</td>
        </tr>
    </c:forEach>
</table>
<br>
    <div style="width: 500px; margin-left: 300px;">
    <p><font color="red">${errorMessage}</font></p>
<p id="p1">Add new group member</p>
<form action="ServletGroup" method="post" id="check1">
    Name: <input type="text" name="newName"><br>
    Surname: <input type="text" name="newSurname"><br>
    Email: <input type="text" name="newEmail"><br>
    <br>
    <input type="submit" value="Add" name="checkBut">
    <input type="button" value="Revoke" id="but1">
</form>
        <p id="p2">Choice of the parameter</p>
        <form action="" method="post" id="check2">
            Enter name member <input type="text" name="ChoiseName">
            <br>
            <input type="submit" value="Select" name="checkBut">
            <input type="button" value="Revoke" id="but2">
        </form>
        <p id="p3">Update information</p>
        <form action="" method="post" id="check3">
            Enter name member <input type="text" name="UpdateName"><br>
            Enter new email <input type="text" name="UpdateEmail">
            <br>
            <input type="submit" value="Update" name="checkBut">
            <input type="button" value="Revoke" id="but3">
        </form>
        <p id="p4">Delete member</p>
        <form action="" method="post" id="check4">
            Enter name <input type="text" name="DeleteName"><br>
            Enter surname <input type="text" name="DeleteSurname">
            <br>
            <br>
            <input type="submit" value="Delete" name="checkBut">
            <input type="button" value="Revoke" id="but4">
        </form>
    </div>
</div>
<footer class="footer">
    <div class="container">
        <p>2020 Все права защищены</p>
    </div>
</footer>
</body>
</html>
