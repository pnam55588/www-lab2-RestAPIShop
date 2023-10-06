package frontend.models;

import fit.iuh.wwwlab2shop.models.OrderDetail;
import fit.iuh.wwwlab2shop.models.Product;
import fit.iuh.wwwlab2shop.models.ProductPrice;
import fit.iuh.wwwlab2shop.services.OrderService;
import fit.iuh.wwwlab2shop.services.ProductService;
import fit.iuh.wwwlab2shop.services.servicesImpl.OrderServiceImpl;
import fit.iuh.wwwlab2shop.services.servicesImpl.ProductServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderModel {
    private final OrderService orderService;
    public final ProductService productService;
    public OrderModel(){
        orderService = new OrderServiceImpl();
        productService = new ProductServiceImpl();
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
        orderService.create(1,1,ods);

    }

    public void buyProducts(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Map<Integer, Integer> carts = (Map<Integer, Integer>) session.getAttribute("carts");
        List<OrderDetail> ods = new ArrayList<>();
        carts.entrySet().forEach(entry ->{
            int id = entry.getKey();
            int quantity = entry.getValue();
            OrderDetail od = new OrderDetail();
            Product p = new Product();
            ProductPrice pp = productService.getPrice(id);

            p.setId(id);
            od.setProduct(p);
            od.setPrice(pp.getPrice());
            od.setQuantity(quantity);
            ods.add(od);
        });
        orderService.create(2,2, ods);
        resp.sendRedirect("products.jsp");
    }
}
