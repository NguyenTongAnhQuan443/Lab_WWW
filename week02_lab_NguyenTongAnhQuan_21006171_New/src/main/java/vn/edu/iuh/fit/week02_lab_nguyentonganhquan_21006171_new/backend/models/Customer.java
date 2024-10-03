package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
@NamedQueries({
        @NamedQuery(name = "Customer.findAll", query = "select c from Customer c")
})
public class Customer {
//    customer (cust_id, cust_name, email, phone, address)

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "cust_id", columnDefinition = "BIGINT(20)")
    private long cust_id;

    @Column(name = "cust_name", columnDefinition = "VARCHAR(150)", nullable = false)
    private String cust_name;

    @Column(name = "email", columnDefinition = "VARCHAR(150)")
    private String email;

    @Column(name = "phone", columnDefinition = "VARCHAR(15)", nullable = false)
    private String phone;

    @Column(name = "address", columnDefinition = "VARCHAR(250)", nullable = false)
    private String address;

    @OneToMany(mappedBy = "cust_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orders;

    public long getCust_id() {
        return cust_id;
    }

    public void setCust_id(long cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Customer(long cust_id, String cust_name, String email, String phone, String address, List<Order> orders) {
        this.cust_id = cust_id;
        this.cust_name = cust_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.orders = orders;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cust_id=" + cust_id +
                ", cust_name='" + cust_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", orders=" + orders +
                '}';
    }
}
