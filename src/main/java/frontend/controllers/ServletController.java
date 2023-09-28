package frontend.controllers;

import frontend.models.ProductModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

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
            default:
                resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        ProductModel pm = new ProductModel();
        switch (action){
            case "delete_product":
                pm.deleteProduct(req,resp);
                break;
            default:
                resp.sendRedirect("index.jsp");
        }
    }
}
