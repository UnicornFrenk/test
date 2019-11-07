<%--
  Created by IntelliJ IDEA.
  User: tanya_melgui
  Date: 11.10.19
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create order </title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/createOrder">

<table border="2">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Description</td>
        <td>Total Quantity</td>
        <td>Price For One</td>
        <td>i want it</td>

    </tr>
    <c:forEach items="${items}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.itemName}</td>
            <td>${item.itemDescription}</td>
            <td>${item.itemQuantity}</td>
            <td>${item.priceForOne}</td>
            <td></td>
        </tr>
    </c:forEach>
</table>
</form>
</body>
</html>
