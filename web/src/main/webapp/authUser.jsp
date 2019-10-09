//after registration


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>authuser</title>
</head>
<body>
<div>

        <h3 align="center">Hi, ${login} ! We glad to see you!</h3>

    <form align="right" method="post" action="/createOrder">
        <input type="button" style="text-align:right" required placeholder="submit" value="crete order">
    </form>


    <form align="right" method="post" action="${pageContext.request.contextPath}/login">
        <input type="button" required placeholder="submit" value="logout">
    </form>
</div>
</body>
</html>
