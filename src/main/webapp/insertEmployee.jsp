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
    <a href="index.jsp">return</a>
</nav>
    <h1 align="center">Insert Employee</h1>
    <div align="center">
        <form action="controls?action=insert_employee" method="post">
            name: <input name="name" required> <br>
            day of birth: <input type="datetime-local" name="dob" required> <br>
            email: <input name="email" required> <br>
            address: <input name="address"> <br>
            status: <select name="status">
            <option selected="true" value="ACTIVE">ACTIVE</option>
            <option value="ON_LEAVE">ON_LEAVE</option>
            <option value="TERMINATED">TERMINATED</option>
            </select><br>
            <input type="submit" value="insert">
            <input type="reset" value="clear">
        </form>
    </div>
</body>
</html>
