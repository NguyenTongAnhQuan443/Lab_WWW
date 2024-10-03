package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "customer")
@NamedQueries({
        @NamedQuery(name = "Customer.getPageNum", query = "select c from Customer c"),
        @NamedQuery(name = "Customer.findCustomerByIdJoinFetch",
                query = "select c from Customer c join FETCH c.orderList where c.cust_id =:id"
        ),
        @NamedQuery(name = "Customer.findAll", query = "select c from Customer c"),
        @NamedQuery(name = "Customer.findByEmail", query = "select c from Customer c where c.email = :email")
})
public class Customer {
//    customer (cust_id, cust_name, email, phone, address)

    @Id
    @Column(name = "cust_id", columnDefinition = "BIGINT(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cust_id;

    @Column(name = "cust_name", columnDefinition = "VARCHAR(150)")
    private String cust_name;

    @Column(name = "email", columnDefinition = "VARCHAR(150)")
    private String email;

    @Column(name = "phone", columnDefinition = "VARCHAR(15)")
    private String phone;

    @Column(name = "address", columnDefinition = "VARCHAR(250)")
    private String address;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orderList;

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
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

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Customer(Long cust_id, String cust_name, String email, String phone, String address, List<Order> orderList) {
        this.cust_id = cust_id;
        this.cust_name = cust_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.orderList = orderList;
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
                ", orderList=" + orderList +
                '}';
    }
}

