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
    <h3>You can buy something only after registration!</h3>

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
                <form align="right" method="get" action="${pageContext.request.contextPath}/createOrder">
                    <button type="submit" style="text-align:right" value="crete order">Create order</button>
                </form>
            </td>
        </tr>
    </table>
    <br>
    <br>
    <br>

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
            <td>item_category</td>
            <td>price_for_one</td>
            <td><input type="checkbox"></td>
        </tr>
    </table>

    <form align="center" method="post" action="${pageContext.request.contextPath}/basket">
        <button type="submit" >add to basket</button>
    </form>

</div>
</body>
</html>