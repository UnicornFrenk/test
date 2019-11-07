//список зарегистрированных юзеров для админов
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h1>Users!</h1>
<table border="3">
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.role}</td>
            <td>
                <form method="post" action="${pageContext.request.contextPath}/deleteUser">
                    <button type="submit" name="deleteUser" value="${user.id}">Delete User</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
