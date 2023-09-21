package fit.iuh.wwwlab2shop.repositories;

import fit.iuh.wwwlab2shop.enums.EmployeeStatus;
import fit.iuh.wwwlab2shop.models.Customer;
import fit.iuh.wwwlab2shop.models.Employee;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CustomerRepository extends  GenericCRUD<Customer>{
    public List<Customer> paging(int page, int limit) {
        EntityTransaction tr = em.getTransaction();
        try {
            if(!tr.isActive()){
                tr.begin();
            }
            TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c", Customer.class);
            query.setFirstResult((page - 1) * limit);
            query.setMaxResults(limit);
            List<Customer> customers = query.getResultList();
            return customers;
        }catch (Exception e){
            tr.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }

}
