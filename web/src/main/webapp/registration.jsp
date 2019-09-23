<%--
  Created by IntelliJ IDEA.
  User: tanya_melgui
  Date: 21.09.19
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Registration Form</title>
</head>
<body>
<h1>Hi, new User!</h1>

<table>
    <tr>
        <td>Введите имя пользователя:</td>
        <td><input type="text" required placeholder="login" name="Input login"><br></td>
    </tr>
    <tr>
        <td>Введите пароль:</td>
        <td><input type="password" required placeholder="password" name="Input password"><br></td>
    </tr>
    <tr>
        <td>Повторите пароль:</td>
        <td><input type="password" required placeholder="repeat" name="Repeat password"><br></td>
    </tr>
    <tr>
        <td>Введи свое имя:</td>
        <td><input type="text" required placeholder="name" name="Input your name"><br></td>
    </tr>
    <tr>
        <td>Сколько тебе лет:</td>
        <td><input type="text" required placeholder="age" name="Input your age"><br></td>
    </tr>
    <tr>
        <td> Hi, new User!</td>
        <td>
            <form method="post" action="/registration"><input type="button" required placeholder="submit"
                                                              value="Submit"><br></form>
        </td>
    </tr>


</table>


</body>
</html>
