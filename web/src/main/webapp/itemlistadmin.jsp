<%--
  Created by IntelliJ IDEA.
  User: tanya_melgui
  Date: 13.10.19
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Item List For Admin </title>
</head>
<body>

Items list
<table border="2">
    <tr>
        <td>id</td>
        <td>Name</td>
        <td>Description</td>
        <td>Total Quantity</td>
        <td>CategoryId</td>
        <td>Price For One</td>
        <td>Update</td>
        <td>Delete</td>

    </tr>
    <c:forEach items="${items}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.itemName}</td>
            <td>${item.itemDescription}</td>
            <td>${item.itemQuantity}</td>
            <td>${item.itemCategoryId}</td>
            <td>${item.priceForOne}</td>
            <td>
                <form method="post"  action="${pageContext.request.contextPath}/deleteitem">
                    <button type="submit" name="del" value="${item.itemName}">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>


<button><a href="${pageContext.request.contextPath}/createitem.jsp">create new item</a></button>
<br/>
</body>
</html>
