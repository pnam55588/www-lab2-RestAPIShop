package fit.iuh.wwwlab2shop.models;

public class ProductImage {
//    product_image (product_id, image_id, path, alternative
    private Product product;
    private int id;
    private String path;
    private String alternative;

    public ProductImage() {
    }

    public ProductImage(Product product, int id, String path, String alternative) {
        this.product = product;
        this.id = id;
        this.path = path;
        this.alternative = alternative;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "product=" + product +
                ", id=" + id +
                ", path='" + path + '\'' +
                ", alternative='" + alternative + '\'' +
                '}';
    }
}

