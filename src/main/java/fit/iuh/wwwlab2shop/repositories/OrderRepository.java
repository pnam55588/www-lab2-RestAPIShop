package fit.iuh.wwwlab2shop.repositories;

import fit.iuh.wwwlab2shop.models.Customer;
import fit.iuh.wwwlab2shop.models.Employee;
import fit.iuh.wwwlab2shop.models.OrderDetail;
import fit.iuh.wwwlab2shop.models.Orders;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDateTime;
import java.util.List;

public class OrderRepository extends GenericCRUD<Orders> {
    public List<Orders> paging(int page, int limit){
        EntityTransaction tr = em.getTransaction();
        try {
            if(!tr.isActive()){
                tr.begin();
            }
            TypedQuery<Orders> query = em.createQuery("SELECT o FROM Orders o", Orders.class);
            query.setFirstResult((page - 1) * limit);
            query.setMaxResults(limit);
            List<Orders> orders = query.getResultList();
            tr.commit();
            return orders;
        }catch (Exception e){
            tr.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }
    public List<Orders> findByMonth(int month, int year){
        EntityTransaction tr = em.getTransaction();
        try {
            if(!tr.isActive()){
                tr.begin();
            }
            TypedQuery<Orders> query = em.createQuery("SELECT o FROM Orders o where month(o.orderDate)=:m and year(o.orderDate)=:y", Orders.class);
            query.setParameter("m",month);
            query.setParameter("y",year);
            List<Orders> orders = query.getResultList();
            tr.commit();
            return orders;
        }catch (Exception e){
            tr.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }
    public List<Orders> findByEmpAnhMonth(int idEmp, int month, int year){
        EntityTransaction tr = em.getTransaction();
        try {
            if(!tr.isActive()){
                tr.begin();
            }
            TypedQuery<Orders> query = em.createQuery("SELECT o FROM Orders o join o.employee e where month(o.orderDate)=:m and YEAR(o.orderDate)=:y and e.id=:id", Orders.class);
            query.setParameter("m",month);
            query.setParameter("y",year);
            query.setParameter("id",idEmp);

            List<Orders> orders = query.getResultList();
            tr.commit();
            return orders;
        }catch (Exception e){
            tr.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean create(int empId, int custId, List<OrderDetail> ods){
        EntityTransaction tr = em.getTransaction();
        try {
            if(!tr.isActive()){
                tr.begin();
            }
            Employee emp = em.find(Employee.class,empId);
            Customer cust = em.find(Customer.class,custId);
            Orders order = new Orders();
            order.setOrderDate(LocalDateTime.now());
            if(emp != null) order.setEmployee(emp);
            if(cust != null) order.setCustomer(cust);
            em.persist(order);
            ods.forEach(od ->{
                od.setOrder(order);
                em.persist(od);
            });
            tr.commit();
            return true;
        }catch (Exception e){
            tr.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }

}
