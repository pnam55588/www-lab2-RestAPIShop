package fit.iuh.wwwlab2shop.test;

import fit.iuh.wwwlab2shop.db.JPAConnection;
import fit.iuh.wwwlab2shop.enums.ProductStatus;
import fit.iuh.wwwlab2shop.models.*;
import fit.iuh.wwwlab2shop.repositories.CustomerRepository;
import fit.iuh.wwwlab2shop.repositories.EmployeeRepository;
import fit.iuh.wwwlab2shop.repositories.ProductRepository;
import fit.iuh.wwwlab2shop.services.CustomerService;
import fit.iuh.wwwlab2shop.services.EmployeeService;
import fit.iuh.wwwlab2shop.services.servicesImpl.CustomerServiceImpl;
import fit.iuh.wwwlab2shop.services.servicesImpl.EmployeeServiceImpl;
import jakarta.persistence.EntityManager;
import org.checkerframework.checker.units.qual.C;
import org.hibernate.dialect.Dialect;
import org.mariadb.jdbc.Driver;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
//        EntityManager em = JPAConnection.getInstance().getEm();
        ProductRepository res = new ProductRepository();
        ProductPrice productPrice = res.getPrice(13);
        System.out.println(productPrice);
//        Product product = new Product();
//        product.setId(10);
//        product.setName("xe may"); product.setUnit("xe"); product.setStatus(ProductStatus.IN_BUSINESS);
//        res.update(product);
//        res.delete(2);
//        List<Product> products = res.getAll(Product.class);
//        products.forEach(p -> System.out.println(p));
//        Product product = res.findById(Product.class, 2);
//        List<String> paths = new ArrayList<>();
//        for(int i = 0 ; i<5;i++){
//            paths.add("path" + i);
//        }
//        res.addImages(2,paths);
//        List<ProductImage> productImages = res.getImages(2);
//        productImages.forEach(pi -> System.out.println(pi));
//        res.updatePrice(4, 222);
    }

}
