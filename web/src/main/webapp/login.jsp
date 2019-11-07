<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>login</title>
</head>
<body>
<%@include file="languages.jsp"%>
<c:forEach var="user" items="user"/>
<div class="form">
    <h1>Вход в систему</h1><br>

    <form method="post" action="${pageContext.request.contextPath}/login">
        <input type="text" name="login" value="${user.login}"><br>
        <input type="password" name="password" value="${user.password}"><br>
        <button type="submit" value="Submit">Submit</button>

    </form>
</div>
</body>
</html>