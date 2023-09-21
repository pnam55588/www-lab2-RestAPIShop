package fit.iuh.wwwlab2shop.services.servicesImpl;

import fit.iuh.wwwlab2shop.enums.EmployeeStatus;
import fit.iuh.wwwlab2shop.models.Employee;
import fit.iuh.wwwlab2shop.repositories.EmployeeRepository;
import fit.iuh.wwwlab2shop.services.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(){
        this.employeeRepository = new EmployeeRepository();
    }
    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll(Employee.class);
    }

    @Override
    public boolean create(Employee emp) {
        return employeeRepository.create(emp);
    }

    @Override
    public boolean update(Employee emp) {
        return employeeRepository.update(emp);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(Employee.class,id);
    }

    @Override
    public boolean activeEmployee(int id) {
        return employeeRepository.activeEmployee(id);
    }

    @Override
    public boolean delete(int id){ return employeeRepository.delete(id);}
}
