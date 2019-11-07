


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>authUser</title>
</head>
<body>
<div>

        <h3 align="center">Hi, ${login} ! We glad to see you!</h3>


    <c:choose>
        <c:when test="${login == 'ADMIN'}">
            <a href="${pageContext.request.contextPath}/itemlistadmin">items</a>
            <a href="${pageContext.request.contextPath}/users">users</a>
            <a href="${pageContext.request.contextPath}/WEB-INF/index.jsp">logout</a>

            <br/>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/itemlist">items</a>

        </c:otherwise>
    </c:choose>


</div>
</body>
</html>
