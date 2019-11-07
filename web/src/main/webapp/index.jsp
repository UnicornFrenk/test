<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>login</title>
</head>
<body>
<div class="form">
    <h1>Hi! We glad to see you!</h1><br>
    <h3>You can buy something only after registration!</h3>

    <table>
        <tr>
            <td>
                <form action="${pageContext.request.contextPath}/login">
                    <button type="submit" value="Войти">Войти</button>
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/registration">
                    <button type="submit" value="Регистрация">Регистрация</button>
                </form>
            </td>
            <td>
                <form align="right" method="get" action="${pageContext.request.contextPath}/createOrder">
                    <button><a href="${pageContext.request.contextPath}/createOrder">create new order</a></button>
                </form>
            </td>
        </tr>
    </table>
    <br>
    <br>
    <br>

    <a href="${pageContext.request.contextPath}/itemlist">items</a>
    <a href="${pageContext.request.contextPath}/users">users</a>

</div>
</body>
</html>