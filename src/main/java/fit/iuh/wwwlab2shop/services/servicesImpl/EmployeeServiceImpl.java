package fit.iuh.wwwlab2shop.services.servicesImpl;

import fit.iuh.wwwlab2shop.models.Employee;
import fit.iuh.wwwlab2shop.services.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    public boolean create(Employee emp) {
        return false;
    }

    @Override
    public boolean update(Employee emp) {
        return false;
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public boolean changeStatus(int id, int status) {
        return false;
    }
}
