<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>ItemList</title>
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

    </tr>
    <c:forEach items="${items}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.itemName}</td>
            <td>${item.itemDescription}</td>
            <td>${item.itemQuantity}</td>
            <td>${item.itemCategoryId}</td>
            <td>${item.priceForOne}</td>
        </tr>
    </c:forEach>
</table>


<form align="center" method="post" action="${pageContext.request.contextPath}/createOrder">
    <button type="submit" value="add to basket">create order</button>
</form>
<br/>
</body>
</html>
