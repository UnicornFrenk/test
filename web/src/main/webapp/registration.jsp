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
        <td> Hi, new User!</td>
        <td>

                <input type="submit" value="Submit"><br>
        </td>
    </tr>


</table>
</form>


</body>
</html>
