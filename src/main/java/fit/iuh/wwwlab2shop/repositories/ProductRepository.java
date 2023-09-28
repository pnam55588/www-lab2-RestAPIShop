package fit.iuh.wwwlab2shop.repositories;


import fit.iuh.wwwlab2shop.enums.ProductStatus;
import fit.iuh.wwwlab2shop.models.Product;
import fit.iuh.wwwlab2shop.models.ProductImage;
import fit.iuh.wwwlab2shop.models.ProductPrice;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;


import java.time.LocalDateTime;
import java.util.List;

public class ProductRepository extends GenericCRUD<Product> {
    public List<Product> paging(int page, int limit){
        EntityTransaction tr = em.getTransaction();
        try {
            if(!tr.isActive()){
                tr.begin();
            }
            TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
            query.setFirstResult((page - 1) * limit);
            query.setMaxResults(limit);
            List<Product> products = query.getResultList();
            return products;
        }catch (Exception e){
            tr.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<ProductImage> getImages(int id){
        EntityTransaction tr = em.getTransaction();
        try {
            if(!tr.isActive()){
                tr.begin();
            }
            TypedQuery<ProductImage> query = em.createQuery(
                    "SELECT pi FROM ProductImage pi WHERE  pi.product.id = :id",
                    ProductImage.class
            );
            query.setParameter("id", id);
            List<ProductImage> productImages = query.getResultList();
            tr.commit();
            return productImages;
        }catch (Exception e){
            tr.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }

    public ProductPrice getPrice(int id){
        EntityTransaction tr = em.getTransaction();
        try {
            if(!tr.isActive()){
                tr.begin();
            }
            TypedQuery<ProductPrice> query = em.createQuery(
                    "SELECT pr FROM ProductPrice pr WHERE  pr.product.id = :id order by priceDateTime desc",
                    ProductPrice.class
            );
            query.setParameter("id",id);
            ProductPrice price = query.getSingleResult();
            tr.commit();
            return price;
        }catch (Exception e){
            tr.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean active(int id){
        EntityTransaction tr = em.getTransaction();
        try {
            if(!tr.isActive()){
                tr.begin();
            }
            Product product = findById(Product.class, id);
            if(product!=null){
                ProductStatus productStatus = product.getStatus();
                if(productStatus != ProductStatus.IN_BUSINESS){
                    product.setStatus(ProductStatus.IN_BUSINESS);
                    em.merge(product);
                }else {
                    return false;
                }
            }else {
                return false;
            }
            return true;
        }catch (Exception e){
            tr.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean delete(int id) {
        EntityTransaction tr = em.getTransaction();
        try {
            if(!tr.isActive()){
                tr.begin();
            }
            Product product = em.find(Product.class, id);
            if(product==null)
                return false;
            if(product.getStatus()==ProductStatus.OUT_OF_BUSINESS){
                return false;
            }
            product.setStatus(ProductStatus.OUT_OF_BUSINESS);
            em.merge(product);
            tr.commit();
            return true;
        }catch (Exception e){
            tr.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }
    public boolean updatePrice(int id, double price){
        EntityTransaction tr = em.getTransaction();
        try {
            if(!tr.isActive()){
                tr.begin();
            }
            Product product = em.find(Product.class, id);
            if(product == null){
                return false;
            }
            ProductPrice productPrice = new ProductPrice();
            productPrice.setProduct(product);
            LocalDateTime time = LocalDateTime.now();
            productPrice.setPriceDateTime(time); // now, price time is joda datetime
            productPrice.setPrice(price);
            em.persist(productPrice);
            tr.commit();
            return true;
        }catch (Exception e){
            tr.rollback();
            throw  new RuntimeException(e.getMessage());
        }
    }
    public boolean addImages (int id, List<String> paths){
        EntityTransaction tr = em.getTransaction();
        try {
            if(!tr.isActive()){
                tr.begin();
            }
            Product product = em.find(Product.class, id);
            if(product == null){
                return false;
            }
            paths.forEach(p ->{
                ProductImage productImage = new ProductImage();
                productImage.setProduct(product);
                productImage.setPath(p);
                em.persist(productImage);
            });
            tr.commit();
            return true;
        }catch (Exception e){
            tr.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }
    public boolean deleteImage(int idImg){
        EntityTransaction tr = em.getTransaction();
        try {
            if(!tr.isActive()){
                tr.begin();
            }
            ProductImage prodImg = em.find(ProductImage.class, idImg);
            if(prodImg == null){
                return false;
            }
            em.remove(prodImg);
            tr.commit();
            return true;
        }catch (Exception e){
            tr.rollback();
            throw new RuntimeException(e.getMessage());
        }
    }
}
