


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>authuser</title>
</head>
<body>
<div>

        <h3 align="center">Hi, ${login} ! We glad to see you!</h3>


    <c:choose>
        <c:when test="${login == 'ADMIN'}">
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
                    <td>delete_item</td>
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
                    <td><button style="border: black" >delete</button></td>
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
                    <td><button style="border: black" >delete</button></td>
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
                    <td><button style="border: black" >delete</button></td>
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
                    <td><button style="border: black" >delete</button></td>
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
                    <td><button style="border: black" >delete</button></td>
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
                    <td><button style="border: black" >delete</button></td>
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
                    <td><button style="border: black" >delete</button></td>
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
                    <td><button style="border: black" >delete</button></td>
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
                    <td><button style="border: black" >delete</button></td>
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
                    <td><button style="border: black" >delete</button></td>
                </tr>
            </table>

            <form align="center" method="post" action="${pageContext.request.contextPath}/basket">
                <button type="submit"  value="add to basket">add to basket</button>
            </form>
            <form align="center" method="get" action="${pageContext.request.contextPath}/mainpage">
                <button type="submit"  value="mainpage">main page</button>
            </form>
            <br/>
        </c:when>
        <c:otherwise>
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
                <button type="submit"  value="add to basket">add to basket</button>
            </form>
            <br />
        </c:otherwise>
    </c:choose>


</div>
</body>
</html>
