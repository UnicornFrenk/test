<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/updateitem">
    <table border="2">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Description</td>
            <td>Total Quantity</td>
            <td>Price For One</td>

        </tr>

        <tr>
            <td>${item.id}</td>
            <td>${item.itemName}</td>
            <td>${item.itemDescription}</td>
            <td>${item.itemQuantity}</td>
            <td><input type="text" name="price" value="${item.priceForOne}">
                <input hidden="true" type="number" name="updateId" value="${item.id}"></td>
            <td><input type="submit" value="Update"></td>
        </tr>


    </table>
</form>


</body>
</html>
