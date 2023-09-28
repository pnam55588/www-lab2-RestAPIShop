package frontend.controllers;

import frontend.models.ProductModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        HttpSession session =req.getSession();
        List<Integer> carts = (List<Integer>) session.getAttribute("carts");
        if(carts == null){
            carts = new ArrayList<Integer>();
            session.setAttribute("carts",carts);
        }
        switch (action){
            case "delete_product":
                pm.deleteProduct(req,resp);
                break;
            case "add_to_carts":
                int id = Integer.parseInt(req.getParameter("id"));
                carts.add(id);
                session.setAttribute("carts",carts);
                resp.sendRedirect("products.jsp");
                break;
            default:
                resp.sendRedirect("index.jsp");
        }
    }
}
