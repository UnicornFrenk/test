<%--
  Created by IntelliJ IDEA.
  User: tanya_melgui
  Date: 13.10.19
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
        <td>Price For One</td>
        <td>Update</td>
        <td>Delete</td>

    </tr>
    <c:forEach items="${items}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.description}</td>
            <td>${item.quantity}</td>
            <td>${item.price}</td>
            <td><a href="${pageContext.request.contextPath}/updateitem?id=${item.id}">update item</a></td>
            <td>
                <form method="post" action="${pageContext.request.contextPath}/deleteitem">
                    <input hidden="true" type="number" name="del" value="${item.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<c:forEach begin="1" end="${pageCount}" var="pageNumber">
    <a href="${pageContext.request.contextPath}/itemlistadmin?pageNumber=${pageNumber}">${pageNumber}</a>
</c:forEach>

<button><a href="${pageContext.request.contextPath}/createitem">create new item</a></button>
<br/>
</body>
</html>
