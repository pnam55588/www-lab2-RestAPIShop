package fit.iuh.wwwlab2shop.services;

import fit.iuh.wwwlab2shop.models.Customer;
import java.util.List;

public interface CustomerService{
    public List<Customer> paging(int page, int limit);
    public List<Customer> getAll();
    public boolean create(Customer customer);
    public boolean update(Customer customer);
    public Customer findById(int id);
}
