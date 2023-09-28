package fit.iuh.wwwlab2shop.repositories;

import fit.iuh.wwwlab2shop.enums.EmployeeStatus;
import fit.iuh.wwwlab2shop.models.Employee;
import jakarta.persistence.EntityTransaction;

public class EmployeeRepository extends GenericCRUD<Employee>{
    public boolean activeEmployee(int id) {
        EntityTransaction tr = em.getTransaction();
        try {
            if(!tr.isActive()){
                tr.begin();
            }
            Employee employee = findById(Employee.class, id);
            if(employee!=null){
                EmployeeStatus empStatus = employee.getStatus();
                if(empStatus != EmployeeStatus.ACTIVE){
                    employee.setStatus(EmployeeStatus.ACTIVE);
                    em.merge(employee);
                }else {
                    return false;
                }
            }else {
                return false;
            }
            return true;
        }catch (Exception e){
            tr.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean delete(int id) {
        EntityTransaction tr = em.getTransaction();
        try {
            if(!tr.isActive()){
                tr.begin();
            }
            Employee employee = findById(Employee.class, id);
            if(employee!=null){
                EmployeeStatus empStatus = employee.getStatus();
                if(empStatus != EmployeeStatus.TERMINATED){
                    employee.setStatus(EmployeeStatus.TERMINATED);
                    em.merge(employee);
                    tr.commit();
                }else {
                    return false;
                }
            }else {
                return false;
            }
            return true;
        }catch (Exception e){
            tr.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }
}
