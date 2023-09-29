package frontend.controllers;

import frontend.models.OrderModel;
import frontend.models.ProductModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.*;

@WebServlet("/controls")
public class ServletController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        ProductModel pm = new ProductModel();
        switch (action){
            case "insert_product":
                pm.insertProduct(req, resp);
                break;
            case "delete_product":
                pm.deleteProduct(req,resp);
                break;
            case "edit_product":
                pm.updateProduct(req,resp);
                break;
            default:
                resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        ProductModel pm = new ProductModel();
        OrderModel om = new OrderModel();
        switch (action){
            case "delete_product":
                pm.deleteProduct(req,resp);
                break;
            case "add_to_carts":
                addToCarts(req,resp);
                break;
            case "delete_cart":
                deleteCart(req,resp);
                break;
            case "buy_product":
                om.buyProduct(req,resp);
                deleteCart(req,resp);
                break;
            default:
                resp.sendRedirect("index.jsp");
        }
    }

    private void deleteCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Map<Integer,Integer> carts = (Map<Integer, Integer>) session.getAttribute("carts");
        int id = Integer.parseInt(req.getParameter("id"));
        carts.remove(id);
        resp.sendRedirect("carts.jsp");
    }

    private void addToCarts(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Map<Integer,Integer> carts = (Map<Integer, Integer>) session.getAttribute("carts");
        if(carts == null){
            carts = new HashMap<>();
            session.setAttribute("carts",carts);
        }
        int id = Integer.parseInt(req.getParameter("id"));
        int quantity = 1;
        if(carts.containsKey(id)){
            quantity =  carts.get(id) +1;
        }
        carts.put(id,quantity);
        session.setAttribute("carts",carts);
        resp.sendRedirect("products.jsp");
    }
}

