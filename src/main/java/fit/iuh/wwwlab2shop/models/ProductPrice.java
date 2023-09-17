package fit.iuh.wwwlab2shop.models;

import jakarta.persistence.*;
import org.joda.time.DateTime;

import java.io.Serializable;

@Entity
@Table(name = "product_price")
public class ProductPrice implements Serializable {
//    product_price (product_id, price_date_time, price, note)?
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Id
    @Column(name = "price_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private DateTime priceDateTime;
    private double price;
    private String note;

    public ProductPrice() {
    }

    public ProductPrice(Product product, DateTime priceDateTime, double price, String note) {
        this.product = product;
        this.priceDateTime = priceDateTime;
        this.price = price;
        this.note = note;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public DateTime getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(DateTime priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "product=" + product +
                ", priceDateTime=" + priceDateTime +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
