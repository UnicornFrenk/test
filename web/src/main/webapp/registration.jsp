<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Form</title>
</head>
<body>
<h1>Hi, new User!</h1>

<c:forEach var="user" items="users"/>
<form method="post" action="${pageContext.request.contextPath}/registration">
<table>
    <tr><td>Введите имя пользователя:</td>
        <td><input type="text"  name="login" value="${users.login}"><br></td>
    </tr>
    <tr><td>Введите пароль:</td>
        <td><input type="password" name="password" value="${users.password}"><br></td>
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
