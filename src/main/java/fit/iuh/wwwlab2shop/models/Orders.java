package fit.iuh.wwwlab2shop.models;

import jakarta.persistence.*;
import org.joda.time.DateTime;

import java.io.Serializable;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {
//    order (order_id, order_date, emp_id, cust_id)

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "order_date")
    private DateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;

    public Orders() {
    }

    public Orders(int id, DateTime orderDate, Employee employee, Customer customer) {
        this.id = id;
        this.orderDate = orderDate;
        this.employee = employee;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(DateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", employee=" + employee +
                ", customer=" + customer +
                '}';
    }
}

