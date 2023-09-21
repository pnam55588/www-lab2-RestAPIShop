package fit.iuh.wwwlab2shop.repositories;

import fit.iuh.wwwlab2shop.enums.EmployeeStatus;
import fit.iuh.wwwlab2shop.models.Employee;
import jakarta.persistence.EntityTransaction;

public class EmployeeRepository extends GenericCRUD<Employee>{
    public boolean changeStatus(int id, EmployeeStatus status) {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            Employee employee = findById(Employee.class, id);
            if(employee!=null){
                employee.setStatus(status);
                em.merge(employee);
            }else {
                throw new RuntimeException("employee not found");
            }
            tr.commit();
            return true;
        }catch (Exception e){
            tr.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }
}
