package fit.iuh.wwwlab2shop.services;

import fit.iuh.wwwlab2shop.models.Orders;
import fit.iuh.wwwlab2shop.models.OrderDetail;
import java.util.List;
import org.joda.time.DateTime;

public interface OrderService{
    public List<Orders> paging(int page, int limit);
    public boolean create(DateTime time, int empId, int custId, List<OrderDetail> ods);
    public Orders findById(int id);
}
