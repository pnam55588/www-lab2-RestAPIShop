package fit.iuh.wwwlab2shop.services.servicesImpl;

import fit.iuh.wwwlab2shop.models.Product;
import fit.iuh.wwwlab2shop.models.ProductImage;
import fit.iuh.wwwlab2shop.models.ProductPrice;
import fit.iuh.wwwlab2shop.repositories.ProductRepository;
import fit.iuh.wwwlab2shop.services.ProductService;

import java.util.List;

public class ProductServiceImpl  implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(){
        productRepository = new ProductRepository();
    }

    @Override
    public List<Product> paging(int page, int limit) {
        return productRepository.paging(page,limit);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll(Product.class);
    }

    @Override
    public List<ProductImage> getImages(int id) {
        return productRepository.getImages(id);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(Product.class,id);
    }

    @Override
    public ProductPrice getPrice(int id) {
        return productRepository.getPrice(id);
    }

    @Override
    public boolean create(Product product) {
        return productRepository.create(product);
    }

    @Override
    public boolean update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public boolean active(int id) {
        return productRepository.active(id);
    }

    @Override
    public boolean delete(int id) {
        return productRepository.delete(id);
    }

    @Override
    public boolean updatePrice(int id, double price) {
        return productRepository.updatePrice(id,price);
    }

    @Override
    public boolean addImages(int id, List<String> paths) {
        return productRepository.addImages(id,paths);
    }

    @Override
    public boolean deleteImage(int idImg) {
        return productRepository.deleteImage(idImg);
    }
}
