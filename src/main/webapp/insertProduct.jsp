<%--
  Created by IntelliJ IDEA.
  User: phgss
  Date: 9/28/2023
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>insert product</title>
</head>
<body>
<nav>
    <a href="products.jsp">product list</a>
    <a href="orders.jsp">order list</a>
    <a href="carts.jsp">carts</a>
</nav>
    <h1 align="center">Insert Product</h1>
    <div align="center">
        <form action="controls?action=insert_product" method="post">
            name: <input name="name" required> <br>
            description: <input name="description"> <br>
            unit: <input name="unit" required> <br>
            manufacturer name: <input name="manufacturerName"> <br>
            price:  <input type="number" name="price" required> <br>
            status: <select name="status">
            <option selected="true" value="IN_BUSINESS">IN_BUSINESS</option>
            <option value="PAUSED">PAUSED</option>
            <option value="OUT_OF_BUSINESS">OUT_OF_BUSINESS</option>
            </select><br>
            <input type="submit" value="insert">
            <input type="reset" value="clear">
        </form>
    </div>
</body>
</html>
