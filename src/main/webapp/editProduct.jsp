<%@ page import="fit.iuh.wwwlab2shop.models.Product" %>
<%@ page import="fit.iuh.wwwlab2shop.services.ProductService" %>
<%@ page import="fit.iuh.wwwlab2shop.services.servicesImpl.ProductServiceImpl" %>
<%@ page import="fit.iuh.wwwlab2shop.enums.ProductStatus" %>
<%--
  Created by IntelliJ IDEA.
  User: phgss
  Date: 9/28/2023
  Time: 7:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit product</title>
</head>
<body>
    <nav>
        <a href="products.jsp">product list</a>
        <a href="orders.jsp">order list</a>
        <a href="carts.jsp">carts</a>
    </nav>
    <%
        ProductService service = new ProductServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        Product p = service.findById(id);
        ProductStatus status = p.getStatus();
    %>
    <h1 align="center">Update Product</h1>
    <div align="center">
        <form action="controls?action=edit_product" method="post">
            name: <input name="name" value="<%=p.getName()%>" ><br>
            description: <input name="description" value="<%=p.getDescription()%>"> <br>
            unit: <input type="number" name="unit" value="<%=p.getUnit()%>"> <br>
            manufacturer name: <input name="manufacturerName" value="<%=p.getManufacturerName()%>"> <br>
            status: <select name="status">
            <option value="IN_BUSINESS" <%if(status.equals(ProductStatus.IN_BUSINESS)){%>selected="true"<%}%>>IN_BUSINESS</option>
            <option value="PAUSED" <%if(status.equals(ProductStatus.PAUSED)){%>selected="true"<%}%>>PAUSED</option>
            <option value="OUT_OF_BUSINESS" <%if(status.equals(ProductStatus.OUT_OF_BUSINESS)){%>selected="true"<%}%>>OUT_OF_BUSINESS</option>
        </select><br>
            <input type="submit" value="update">
            <input type="reset" value="clear">
        </form>
    </div>
</body>
</html>
