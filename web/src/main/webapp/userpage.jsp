

// after autentification

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserPage</title>
</head>
<body>
<form method="post" action="/orders">
    <input type="button" required placeholder="submit" value="orders">
</form>
<form method="post" action="/pay">
    <input type="button" required placeholder="submit" value="pay">
</form>

<form method="post" action="${pageContext.request.contextPath}/mainPage">
    <input type="button" required placeholder="submit" value="logout">
</form>
</body>
</html>
