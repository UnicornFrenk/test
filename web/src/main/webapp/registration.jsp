<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Registration Form</title>
</head>
<body>
<h1>Hi, new User!</h1>

<form method="post" action="${pageContext.request.contextPath}/registration">

<table>
    <tr>
        <td>Введите имя пользователя:</td>
        <td><input type="text" required placeholder="login"  name="login"><br></td>
    </tr>
    <tr>
        <td>Введите пароль:</td>
        <td><input type="password" required placeholder="password" name="password"><br></td>
    </tr>
    <tr>
        <td>Повторите пароль:</td>
        <td><input type="password" required placeholder="repeat" name="password2"><br></td>
    </tr>
    <tr>
        <td>Введи свое имя:</td>
        <td><input type="text" required placeholder="name" name="name"><br></td>
    </tr>
    <tr>
        <td>Пол:</td>
        <td><input type="text" required placeholder="sex" name="sex"><br></td>
    </tr>
    <tr>
        <td>Сколько тебе лет:</td>
        <td><input type="text" required placeholder="age" name="age"><br></td>
    </tr>
    <tr>
        <td> Hi, new User!</td>
        <td>

                <input type="submit" value="Submit"><br>
        </td>
    </tr>


</table>
</form>


</body>
</html>
