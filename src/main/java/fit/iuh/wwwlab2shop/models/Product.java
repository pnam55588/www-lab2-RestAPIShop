package fit.iuh.wwwlab2shop.models;

import fit.iuh.wwwlab2shop.enums.ProductStatus;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable {
//    product (product_id, name, description, unit, manufacturer_name, status)
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int unit;
    @Column(name = "manufacturer_name")
    private String manufacturerName;
    private ProductStatus status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturer_name) {
        this.manufacturerName = manufacturer_name;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public Product(int id, String name, String description, int unit, String manufacturerName, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturerName = manufacturerName;
        this.status = status;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit=" + unit +
                ", manufacturer_name='" + manufacturerName + '\'' +
                ", status=" + status +
                '}';
    }
}
