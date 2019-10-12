//список зарегистрированных юзеров для админов
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h1>Users!</h1>
<table border="3">
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.role}</td>
            <td>
                <form align="right" method="post" action="${pageContext.request.contextPath}/createOrder">
                    <input type="number" name="id" value="${user.id}" hidden="true"/>
                    <button type="submit" style="text-align:right" value="crete order">Create order</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form align="right" method="get" action="${pageContext.request.contextPath}/createOrder">
    <button type="submit" style="text-align:right" value="crete order">Create order</button>
</form>

</body>
</html>
