<%@ page import="java.util.List" %>
<%@ page import="fit.iuh.wwwlab2shop.services.ProductService" %>
<%@ page import="fit.iuh.wwwlab2shop.services.servicesImpl.ProductServiceImpl" %>
<%@ page import="fit.iuh.wwwlab2shop.models.Product" %><%--
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
    <%
        List<Integer> carts = (List<Integer>) session.getAttribute("carts");
        ProductService service = new ProductServiceImpl();
    %>
    <h1 align="center">Carts</h1>
    <div>
        <table width="70%" align="center" border="1">
            <tr>
                <th>name</th>
                <th>description</th>
                <th>unit</th>
                <th>manufacturer name</th>
                <th>status</th>
                <th colspan="2"><a href="">buy all</a></th>
            </tr>
            <%
                String delete_str = "";
                String buy_str ="";
                if(carts!=null)
                for(int id :carts){
                    Product p = service.findById(id);
            %>
                <tr>
                    <td><%=p.getName()%></td>
                    <td><%=p.getDescription()%></td>
                    <td><%=p.getUnit()%></td>
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
