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
<form method="post" action="/login">
    <input type="text" required placeholder="login" name="login"><br>
    <input type="password" required placeholder="password" name="password"><br>
    <input type="button" required placeholder="submit" value="Submit"><br>
</form>
</div>
</body>
</html>