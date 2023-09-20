package fit.iuh.wwwlab2shop.services.servicesImpl;

import fit.iuh.wwwlab2shop.models.Customer;
import fit.iuh.wwwlab2shop.services.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<Customer> paging(int page, int limit) {
        return null;
    }

    @Override
    public boolean create(Customer customer) {
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public Customer findById(int id) {
        return null;
    }
}
