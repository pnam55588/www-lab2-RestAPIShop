<%@ page import="fit.iuh.wwwlab2shop.services.ProductService" %>
<%@ page import="fit.iuh.wwwlab2shop.services.servicesImpl.ProductServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="fit.iuh.wwwlab2shop.models.Product" %>
<%@ page import="fit.iuh.wwwlab2shop.enums.ProductStatus" %>
<%@ page import="fit.iuh.wwwlab2shop.models.ProductPrice" %><%--
  Created by IntelliJ IDEA.
  User: phgss
  Date: 9/28/2023
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list product</title>
</head>
<body>
    <nav>
        <a href="products.jsp">product list</a>
        <a href="orders.jsp">order list</a>
        <a href="carts.jsp">carts</a>
    </nav>
    <%
        ProductService productService = new ProductServiceImpl();
        List<Product> lst = productService.getAll();
    %>
    <h1 align="center">Product List</h1>
    <table width="70%" align="center" border="1">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>description</th>
            <th>unit</th>
            <th>price</th>
            <th>manufacturer name</th>
            <th>status</th>
            <th colspan="3">
                <a href="insertProduct.jsp">insert</a>
            </th>
        </tr>
        <%
            for(Product p: lst){
                if(p.getStatus().equals(ProductStatus.IN_BUSINESS)){
                    int id = p.getId();
                    String delete_str = "controls?action=delete_product&id="+id;
                    String edit_str = "editProduct.jsp?id="+id;
                    String addToCarts_str = "controls?action=add_to_carts&id="+id;
                    ProductPrice productPrice = productService.getPrice(id);
                    double price = productPrice!=null ? productPrice.getPrice() : 0;
        %>
            <tr>
                <td><%=p.getId()%></td>
                <td><%=p.getName()%></td>
                <td><%=p.getDescription()%></td>
                <td><%=p.getUnit()%></td>
                <td><%=price%></td>
                <td><%=p.getManufacturerName()%></td>
                <td><%=p.getStatus()%></td>
                <td><a href=<%=edit_str%>>update</a></td>
                <td><a href=<%=delete_str%> >delete</a></td>
                <td><a href=<%=addToCarts_str%> >add to carts</a></td>
            </tr>
        <%
            }
        }
        %>
    </table>
</body>
</html>
