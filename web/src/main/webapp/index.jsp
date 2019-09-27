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
                <form  action="${pageContext.request.contextPath}/login">
                    <button type="submit" value="Войти">Войти</button>
                </form>
            </td>
            <td>
                <form  action="${pageContext.request.contextPath}/registration">
                    <button type="submit" value="Регистрация">Регистрация</button>
                </form>
            </td>
        </tr>
    </table>
    <br>
    <br>
    <br>

    <table>
        <tr>
            <td>
                <form method="post" action="/alf">
                    <input type="button" required placeholder="submit" value="АБВ">
                </form>
            </td>
            <td>
                <form method="post" action="/abc">
                    <input type="button" required placeholder="submit" value="АВС">
                </form>
            </td>
            <td>
                <form method="post" action="/123">
                    <input type="button" required placeholder="submit" value="123">
                </form>
            </td>
        </tr>
        <tr>
            <td>
                <form method="post" action="/count">
                    <input type="button" required placeholder="submit" value="Счет">
                </form>
            </td>
            <td>
                <form method="post" action="/words">
                    <input type="button" required placeholder="submit" value="Слова">
                </form>
            </td>
            <td>
                <form method="post" action="/dk">
                    <input type="button" required placeholder="submit" value="Пока хз">
                </form>
            </td>
        </tr>
    </table>

</div>
</body>
</html>