package frontend.models;

import fit.iuh.wwwlab2shop.models.OrderDetail;
import fit.iuh.wwwlab2shop.models.Product;
import fit.iuh.wwwlab2shop.services.OrderService;
import fit.iuh.wwwlab2shop.services.servicesImpl.OrderServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

public class OrderModel {
    private final OrderService service;
    public OrderModel(){
        service = new OrderServiceImpl();
    }

    public void buyProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        double price = Double.parseDouble(req.getParameter("price"));

        Product p = new Product();
        p.setId(id);
        OrderDetail od = new OrderDetail();
        od.setProduct(p);
        od.setQuantity(quantity);
        od.setPrice(price);
        List<OrderDetail> ods = new ArrayList<>();
        ods.add(od);
        service.create(1,1,ods);

    }
}
