package fit.iuh.wwwlab2shop.services;

import fit.iuh.wwwlab2shop.models.Product;
import java.util.List;

public interface ProductService{
    public List<Product> paging(int page, int limit);
    public boolean create(Product customer);
    public boolean update(Product customer);
    public Product findById(int id);
}
