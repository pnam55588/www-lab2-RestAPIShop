<%@ page import="fit.iuh.wwwlab2shop.services.OrderService" %>
<%@ page import="fit.iuh.wwwlab2shop.services.servicesImpl.OrderServiceImpl" %>
<%@ page import="fit.iuh.wwwlab2shop.models.Orders" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: phgss
  Date: 9/29/2023
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list order</title>
</head>
<body>
    <nav>
        <a href="products.jsp">product list</a>
        <a href="orders.jsp">order list</a>
        <a href="carts.jsp">carts</a>
    </nav>
    <%
        OrderService orderService = new OrderServiceImpl();
        List<Orders> lst = orderService.paging(1,10);
    %>
    <h1 align="center">Order List</h1>
    <table width="70%" align="center" border="1">
        <tr>
            <th>id</th>
            <th>customer name</th>
            <th>employee name</th>
            <th>order date</th>
            <th></th>
        </tr>
        <%
            for(Orders o: lst){
    //            if(p.getStatus().equals(ProductStatus.IN_BUSINESS)){
                    int id = o.getId();
                    String detail_str = "";

        %>
        <tr>
            <td><%=o.getId()%></td>
            <td><%=o.getCustomer().getCustName()%></td>
            <td><%=o.getEmployee().getFullName()%></td>
            <td><%=o.getOrderDate()%></td>
            <td><a href=<%=detail_str%>>detail</a></td>
        </tr>
        <%
    //            }
            }
        %>
    </table>
</body>
</html>
