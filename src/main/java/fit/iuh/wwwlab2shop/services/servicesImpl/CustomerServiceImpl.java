package fit.iuh.wwwlab2shop.services.servicesImpl;

import fit.iuh.wwwlab2shop.models.Customer;
import fit.iuh.wwwlab2shop.repositories.CustomerRepository;
import fit.iuh.wwwlab2shop.services.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    public CustomerServiceImpl(){
        customerRepository = new CustomerRepository();
    }

    @Override
    public List<Customer> paging(int page, int limit) {
        return customerRepository.paging(page,limit);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll(Customer.class);
    }
    @Override
    public boolean create(Customer customer) {
        return customerRepository.create(customer);
    }

    @Override
    public boolean update(Customer customer) {
        return customerRepository.update(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(Customer.class,id);
    }

}
