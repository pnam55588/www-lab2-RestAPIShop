package fit.iuh.wwwlab2shop.services;

import fit.iuh.wwwlab2shop.models.Orders;
import fit.iuh.wwwlab2shop.models.OrderDetail;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService{
    public List<Orders> paging(int page, int limit);
    public List<Orders> findByMonth(int month, int year);
    public List<Orders> findByEmpAnhMonth(int idEmp, int month, int year);
    public boolean create(int empId, int custId, List<OrderDetail> ods);
    public Orders findById(int id);

}
