package fit.iuh.wwwlab2shop.services.servicesImpl;

import fit.iuh.wwwlab2shop.models.Product;
import fit.iuh.wwwlab2shop.models.ProductImage;
import fit.iuh.wwwlab2shop.models.ProductPrice;
import fit.iuh.wwwlab2shop.services.ProductService;

import java.util.List;

public class ProductServiceImpl  implements ProductService {

    @Override
    public List<Product> paging(int page, int limit) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public List<ProductImage> getImages(int id) {
        return null;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public ProductPrice getPrice(int id) {
        return null;
    }

    @Override
    public boolean create(Product product) {
        return false;
    }

    @Override
    public boolean update(Product product) {
        return false;
    }

    @Override
    public boolean active(int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean updatePrice(int id, double price) {
        return false;
    }

    @Override
    public boolean addImages(int id, List<String> paths) {
        return false;
    }

    @Override
    public boolean deleteImage(int idImg) {
        return false;
    }
}
