<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>login</title>
</head>
<body>
<c:forEach var="authUser" items="authUsers"/>
<div class="form">
    <h1>Вход в систему</h1><br>

    <form method="post" action="${pageContext.request.contextPath}/authUser">
        <input type="text" name="login" value="${authUsers.login}"><br>
        <input type="password" name="password" value="${authUsers.password}"><br>
        <button type="submit" value="Submit">Submit</button>

    </form>
    <c:out value="${authUsers.message}"/>
</div>
</body>
</html>