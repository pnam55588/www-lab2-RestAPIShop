package fit.iuh.wwwlab2shop.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {
//    order_detail (order_id, product_id, quantity, price, note)
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private int quantity;
    private double price;
    private String note;

    public OrderDetail() {
    }

    public OrderDetail(Orders order, Product product, int quantity, double price, String note) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        return "OrderDetail{" +
                "order=" + order +
                ", product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
