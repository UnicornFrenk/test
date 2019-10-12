<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>ItemList</title>
</head>
<body>





Items list
<table border="3">
    <tr bgcolor="gray">
        <td>item_id</td>
        <td>item_name</td>
        <td>item_description</td>
        <td>item_quantity</td>
        <td>how much you need</td>
        <td>item_categor</td>
        <td>price_for_one</td>
        <td>i_want_it</td>
    </tr>
    <tr>
        <td>item_id</td>
        <td>item_name</td>
        <td>item_description</td>
        <td>item_quantity</td>
        <td><select>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
        </select></td>
        <td>item_categor</td>
        <td>price_for_one</td>
        <td><input type="checkbox"></td>
    </tr>
    <tr>
        <td>item_id</td>
        <td>item_name</td>
        <td>item_description</td>
        <td>item_quantity</td>
        <td><select>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
        </select></td>
        <td>item_categor</td>
        <td>price_for_one</td>
        <td><input type="checkbox"></td>
    </tr>
    <tr>
        <td>item_id</td>
        <td>item_name</td>
        <td>item_description</td>
        <td>item_quantity</td>
        <td><select>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
        </select></td>
        <td>item_categor</td>
        <td>price_for_one</td>
        <td><input type="checkbox"></td>
    </tr>
    <tr>
        <td>item_id</td>
        <td>item_name</td>
        <td>item_description</td>
        <td>item_quantity</td>
        <td><select>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
        </select></td>
        <td>item_categor</td>
        <td>price_for_one</td>
        <td><input type="checkbox"></td>
    </tr>
    <tr>
        <td>item_id</td>
        <td>item_name</td>
        <td>item_description</td>
        <td>item_quantity</td>
        <td><select>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
        </select></td>
        <td>item_categor</td>
        <td>price_for_one</td>
        <td><input type="checkbox"></td>
    </tr>
    <tr>
        <td>item_id</td>
        <td>item_name</td>
        <td>item_description</td>
        <td>item_quantity</td>
        <td><select>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
        </select></td>
        <td>item_categor</td>
        <td>price_for_one</td>
        <td><input type="checkbox"></td>
    </tr>
    <tr>
        <td>item_id</td>
        <td>item_name</td>
        <td>item_description</td>
        <td>item_quantity</td>
        <td><select>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
        </select></td>
        <td>item_categor</td>
        <td>price_for_one</td>
        <td><input type="checkbox"></td>
    </tr>
    <tr>
        <td>item_id</td>
        <td>item_name</td>
        <td>item_description</td>
        <td>item_quantity</td>
        <td><select>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
        </select></td>
        <td>item_categor</td>
        <td>price_for_one</td>
        <td><input type="checkbox" value="true"></td>
    </tr>
    <tr>
        <td>item_id</td>
        <td>item_name</td>
        <td>item_description</td>
        <td>item_quantity</td>
        <td><select>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
        </select></td>
        <td>item_category</td>
        <td>price_for_one</td>
        <td><input type="checkbox"></td>
    </tr>
    <tr>
        <td>item_id</td>
        <td>item_name</td>
        <td>item_description</td>
        <td>item_quantity</td>
        <td><select>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
        </select></td>
        <td>item_category</td>
        <td>price_for_one</td>
        <td><input type="checkbox"></td>
    </tr>
</table>

<form align="center" method="post" action="${pageContext.request.contextPath}/basket">
    <button type="submit"  value="add to basket">add to basket</button>
</form>
<br />
</body>
</html>
