<%--
  Created by IntelliJ IDEA.
  User: tanya_melgui
  Date: 23.09.19
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h1>Users!</h1>
<jsp:useBean id="users" class="Model.AuthUser" scope="page" />
<c:if test="${param.age > 4}">
    Возраст более 4 лет
</c:if>
<c:if test="${param.age <= 4}">
    Возраст не менее 4 лет
</c:if>
</body>
</html>
