package fit.iuh.wwwlab2shop.services.servicesImpl;

import fit.iuh.wwwlab2shop.models.OrderDetail;
import fit.iuh.wwwlab2shop.models.Orders;
import fit.iuh.wwwlab2shop.repositories.OrderRepository;
import fit.iuh.wwwlab2shop.services.OrderService;


import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    public OrderServiceImpl(){
        this.orderRepository = new OrderRepository();
    }

    @Override
    public List<Orders> paging(int page, int limit) {
        return orderRepository.paging(page, limit);
    }

    @Override
    public List<Orders> findByMonth(int month, int year) {
        return orderRepository.findByMonth(month, year);
    }

    @Override
    public List<Orders> findByEmpAnhMonth(int idEmp, int month, int year) {
        return orderRepository.findByEmpAnhMonth(idEmp, month, year);
    }

    @Override
    public boolean create(int empId, int custId, List<OrderDetail> ods) {
        return orderRepository.create(empId, custId,ods);
    }

    @Override
    public Orders findById(int id) {
        return orderRepository.findById(Orders.class,id);
    }
}
