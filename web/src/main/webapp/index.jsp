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
                <form method="post" action="/createOrder">
                    <input type="button" required placeholder="submit" value="crete order">
                </form>
            </td>
        </tr>
    </table>
    <br>
    <br>
    <br>


    <form method="post" action="/items">
        <input type="button" required placeholder="submit" value="items">
    </form>

    <form method="post" action="/categories">
        <input type="button" required placeholder="submit" value="categories">
    </form>

    <form method="post" action="/basket">
        <input type="button" required placeholder="submit" value="basket">
    </form>

    <form method="post" action="${pageContext.request.contextPath}/login">
        <input type="button" required placeholder="submit" value="logout">
    </form>

</div>
</body>
</html>