package fit.iuh.wwwlab2shop.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
//    customer (cust_id, cust_name, email, phone, address)
    @Id
    @Column(name = "cust_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cust_name")
    private String custName;
    private String email;
    private String phone;
    private String address;

    public Customer(){}

    public Customer(int id, String custName, String email, String phone, String address) {
        this.id = id;
        this.custName = custName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + custName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
