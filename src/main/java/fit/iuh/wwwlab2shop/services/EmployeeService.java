package fit.iuh.wwwlab2shop.services;

import fit.iuh.wwwlab2shop.models.Employee;
import java.util.List;

public interface EmployeeService{
    public List<Employee> getAll();
    public boolean create(Employee emp);
    public boolean update(Employee emp);
    public Employee findById(int id);
    public boolean changeStatus(int id, int status);
}
