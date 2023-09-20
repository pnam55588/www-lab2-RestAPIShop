package fit.iuh.wwwlab2shop.services.servicesImpl;

import fit.iuh.wwwlab2shop.models.OrderDetail;
import fit.iuh.wwwlab2shop.models.Orders;
import fit.iuh.wwwlab2shop.services.OrderService;
import org.joda.time.DateTime;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public List<Orders> paging(int page, int limit) {
        return null;
    }

    @Override
    public boolean create(DateTime time, int empId, int custId, List<OrderDetail> ods) {
        return false;
    }

    @Override
    public Orders findById(int id) {
        return null;
    }
}
