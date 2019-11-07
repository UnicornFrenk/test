<%--
  Created by IntelliJ IDEA.
  User: tanya_melgui
  Date: 13.10.19
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Item</title>
</head>
<body>
<h2>Creating new item</h2>
<c:set var="item"/>
<form method="post" action="${pageContext.request.contextPath}/createitem">
    <table border="2">
        <tr>

            <td>Name</td>
            <td>Description</td>
            <td>Total Quantity</td>
            <td>Price For One</td>


        </tr>
        <tr>
            <td><input type="text" name="name" value="${item.itemName}"></td>
            <td><input type="text" name="description" value="${item.itemDescription}"></td>
            <td><input type="text" name="quantity" value="${item.itemQuantity}"></td>
            <td><input type="text" name="price" value="${item.priceForOne}"></td>
        </tr>
    </table>

    <button type="submit" name="create">create</button></form>
</form>
</body>
</html>
