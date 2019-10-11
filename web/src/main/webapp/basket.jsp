
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>busket</title>
</head>
<body>
Items list
<table border="3">
    <tr bgcolor="gray">
        <td>item_name</td>
        <td>item_description</td>
        <td>quantity</td>
        <td>item_categor</td>
        <td>price_for_one</td>
        <td>delete_item</td>
    </tr>
    <tr>
        <td>item_name</td>
        <td>item_description</td>
        <td>quantity</td>
        <td>item_categor</td>
        <td>price_for_one</td>
        <td><button style="border: black" >delete</button></td>
    </tr>
    <tr>
        <td>item_name</td>
        <td>item_description</td>
        <td>quantity</td>
        <td>item_categor</td>
        <td>price_for_one</td>
        <td><button style="border: black" >delete</button></td>
    </tr>
    <tr>
        <td>item_name</td>
        <td>item_description</td>
        <td>quantity</td>
        <td>item_categor</td>
        <td>price_for_one</td>
        <td><button style="border: black" >delete</button></td>
    </tr>
    <tr>
        <td>item_name</td>
        <td>item_description</td>
        <td>quantity</td>
        <td>item_categor</td>
        <td>price_for_one</td>
        <td><button style="border: black" >delete</button></td>
    </tr>
    <tr>
        <td>item_name</td>
        <td>item_description</td>
        <td>quantity</td>
        <td>item_categor</td>
        <td>price_for_one</td>
        <td><button style="border: black" >delete</button></td>
    </tr>
    <tr><td></td><td></td><td></td><td></td><td>total_sum</td><td><button style="border: black" >delete all</button></td></tr>
    <tr><td></td><td></td><td></td><td></td><td></td><td><form method="post" action="${pageContext.request.contextPath}/payment">
        <button style= "color: red"  type="submit"  value="buy">Go to payment</button>
    </form></td></tr>

    </table>


<br/>


</body>
</html>
