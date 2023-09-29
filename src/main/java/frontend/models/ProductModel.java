package frontend.models;

import fit.iuh.wwwlab2shop.enums.ProductStatus;
import fit.iuh.wwwlab2shop.models.Product;
import fit.iuh.wwwlab2shop.services.ProductService;
import fit.iuh.wwwlab2shop.services.servicesImpl.ProductServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ProductModel {
    private final ProductService service;

    public ProductModel(){
        service = new ProductServiceImpl();
    }
    public void insertProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String unit = req.getParameter("unit");
        String manufacturerName = req.getParameter("manufacturerName");
        String status = req.getParameter("status");
        Product p = new Product();
        p.setName(name);
        p.setDescription(description);
        p.setUnit(Integer.parseInt(unit));
        p.setManufacturerName(manufacturerName);
        p.setStatus(ProductStatus.valueOf(status));
        service.create(p);
        resp.sendRedirect("products.jsp");
    }

    public void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        service.delete(id);
        resp.sendRedirect("products.jsp");
    }

    public void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String unit = req.getParameter("unit");
        String manufacturerName = req.getParameter("manufacturerName");
        String status = req.getParameter("status");
        Product p = new Product();
        p.setName(name);
        p.setDescription(description);
        p.setUnit(Integer.parseInt(unit));
        p.setManufacturerName(manufacturerName);
        p.setStatus(ProductStatus.valueOf(status));
        service.update(p);
        resp.sendRedirect("products.jsp");
    }


}
