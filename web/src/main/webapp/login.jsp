<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>login</title>
</head>
<body>
<div class="form">
    <h1>Вход в систему</h1><br>

    <form method="post" action="${pageContext.request.contextPath}/userpage.jsp">
        <input type="text" required placeholder="login" name="login"><br>
        <input type="password" required placeholder="password" name="password"><br>
        <button type="submit"  value="Submit">Submit</button><br>
    </form>

</div>
</body>
</html>