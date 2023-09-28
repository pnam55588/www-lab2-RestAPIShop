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
    <h1 align="center">Insert Product</h1>
    <div align="center">
        <form action="controls?action=insert_product" method="post">
            name: <input name="name"> <br>
            description: <input name="description"> <br>
            unit: <input type="number" name="unit"> <br>
            manufacturer name: <input name="manufacturerName"> <br>
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
