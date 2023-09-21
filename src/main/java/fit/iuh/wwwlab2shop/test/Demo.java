package fit.iuh.wwwlab2shop.test;

import fit.iuh.wwwlab2shop.db.JPAConnection;
import fit.iuh.wwwlab2shop.models.Customer;
import fit.iuh.wwwlab2shop.models.Employee;
import fit.iuh.wwwlab2shop.repositories.CustomerRepository;
import fit.iuh.wwwlab2shop.repositories.EmployeeRepository;
import fit.iuh.wwwlab2shop.services.EmployeeService;
import fit.iuh.wwwlab2shop.services.servicesImpl.EmployeeServiceImpl;
import jakarta.persistence.EntityManager;
import org.hibernate.dialect.Dialect;
import org.mariadb.jdbc.Driver;

import java.util.List;

public class Demo {

    public static void main(String[] args) {
//        EntityManager em = JPAConnection.getInstance().getEm();
        EmployeeService empServ = new EmployeeServiceImpl();
//        Employee emp = new Employee(); emp.setFullName("John Doe");
//        empServ.create(emp);
//        List<Employee> employees = empServ.getAll();
//        employees.forEach(e -> System.out.println(emp));
        Employee empID = empServ.findById(1);
        System.out.println(empID);
    }

}
