package fit.iuh.wwwlab2shop.services.servicesImpl;

import fit.iuh.wwwlab2shop.models.Product;
import fit.iuh.wwwlab2shop.services.ProductService;

import java.util.List;

public class ProductServiceImpl  implements ProductService {
    @Override
    public List<Product> paging(int page, int limit) {
        return null;
    }

    @Override
    public boolean create(Product customer) {
        return false;
    }

    @Override
    public boolean update(Product customer) {
        return false;
    }

    @Override
    public Product findById(int id) {
        return null;
    }
}
