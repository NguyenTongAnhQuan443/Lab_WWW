package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@NamedQueries({
        @NamedQuery(name = "order.findLastOrderByCustId", query = "select o from Order o where o.customer.cust_id = :cust_id order by o.order_date desc"),
        @NamedQuery(name = "Order.findAll", query = "select o from Order o"),

})
public class Order {
    //    order_id, order_date, emp_id, cust_id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", columnDefinition = "BIGINT(20)")
    private long order_id;

    @Column(name = "order_date", columnDefinition = "DATETIME(6)")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime order_date;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "emp_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Order_Detail> orderDetails;

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
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

    public List<Order_Detail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<Order_Detail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Order(long order_id, LocalDateTime order_date, Employee employee, Customer customer, List<Order_Detail> orderDetails) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.employee = employee;
        this.customer = customer;
        this.orderDetails = orderDetails;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_date=" + order_date +
                ", employee=" + employee +
                ", customer=" + customer +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
