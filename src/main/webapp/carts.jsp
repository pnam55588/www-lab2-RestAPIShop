
<%@ page import="fit.iuh.wwwlab2shop.services.ProductService" %>
<%@ page import="fit.iuh.wwwlab2shop.services.servicesImpl.ProductServiceImpl" %>
<%@ page import="fit.iuh.wwwlab2shop.models.Product" %>
<%@ page import="java.util.Map" %>
<%@ page import="fit.iuh.wwwlab2shop.models.ProductPrice" %><%--
  Created by IntelliJ IDEA.
  User: phgss
  Date: 9/28/2023
  Time: 8:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Carts</title>

</head>
<body>
    <nav>
        <a href="products.jsp">product list</a>
        <a href="orders.jsp">order list</a>
        <a href="carts.jsp">carts</a>
    </nav>
    <%
        Map<Integer, Integer> carts = (Map<Integer, Integer>)session.getAttribute("carts");
        ProductService service = new ProductServiceImpl();
    %>
    <h1 align="center">Carts</h1>
    <div>
        <table width="70%" align="center" border="1">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>description</th>
                <th>unit</th>
                <th>quantity</th>
                <th>price</th>
                <th>manufacturer name</th>
                <th>status</th>
                <th colspan="2">
                    <a href="">buy all</a>
                </th>
            </tr>
            <%
                if(carts!=null)
                for(Map.Entry<Integer,Integer> entry :carts.entrySet()){
                    int id = entry.getKey();
                    int quantity = entry.getValue();
                    Product p = service.findById(entry.getKey());
                    ProductPrice productPrice = service.getPrice(id);
                    double price = productPrice!=null ? productPrice.getPrice() : 0;
                    String delete_str = "controls?action=delete_cart&id="+id;
                    String buy_str ="controls?action=buy_product&id="+id+"&quantity="+quantity+"&price="+price;
            %>
                <tr>
                    <td><%=p.getId()%></td>
                    <td><%=p.getName()%></td>
                    <td><%=p.getDescription()%></td>
                    <td><%=p.getUnit()%></td>
                    <td><%=quantity%></td>
                    <td><%=price%></td>
                    <td><%=p.getManufacturerName()%></td>
                    <td><%=p.getStatus()%></td>
                    <td><a href=<%=delete_str%> >delete</a></td>
                    <td><a href=<%=buy_str%> >buy</a></td>
                </tr>
            <%
                }
            %>
        </table>
    </div>
</body>
</html>
