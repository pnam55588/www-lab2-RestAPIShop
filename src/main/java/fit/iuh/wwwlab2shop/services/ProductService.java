package fit.iuh.wwwlab2shop.services;

import fit.iuh.wwwlab2shop.models.Product;
import fit.iuh.wwwlab2shop.models.ProductImage;
import fit.iuh.wwwlab2shop.models.ProductPrice;

import java.util.List;

public interface ProductService{
    public List<Product> paging(int page, int limit);
    public List<Product> getAll();
    public List<ProductImage> getImages(int id);
    public Product findById(int id);
    public ProductPrice getPrice(int id);
    public boolean create(Product product);
    public boolean update(Product product);
    public boolean active(int id);
    public boolean delete(int id);
    public boolean updatePrice(int id, double price);
    public boolean addImages (int id, List<String> paths);
    public boolean deleteImage(int idImg);
}
