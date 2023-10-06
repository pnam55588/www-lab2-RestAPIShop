package frontend.models;

import fit.iuh.wwwlab2shop.enums.EmployeeStatus;
import fit.iuh.wwwlab2shop.models.Employee;
import fit.iuh.wwwlab2shop.services.EmployeeService;
import fit.iuh.wwwlab2shop.services.servicesImpl.EmployeeServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;

public class EmployeeModel {
    private final EmployeeService employeeService = new EmployeeServiceImpl();
    public void validate(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String email = req.getParameter("email");
        Employee e = employeeService.findByEmail(email);
        if(e==null) resp.sendRedirect("index.jsp");
        else{
            HttpSession session = req.getSession();
            session.setAttribute("empLogin",e);
            resp.sendRedirect("products.jsp");
        }
    }

    public void insertEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String dob = req.getParameter("dob");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String status = req.getParameter("status");
        Employee e = new Employee();
        e.setFullName(name);
        e.setDob(LocalDateTime.parse(dob));
        e.setEmail(email);
        e.setAddress(address);
        e.setStatus(EmployeeStatus.valueOf(status));
        employeeService.create(e);
        resp.sendRedirect("index.jsp");
    }
}
