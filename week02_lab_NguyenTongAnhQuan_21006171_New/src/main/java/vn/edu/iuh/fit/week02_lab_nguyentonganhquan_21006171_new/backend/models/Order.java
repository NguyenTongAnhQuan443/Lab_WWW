package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@NamedQueries({
        @NamedQuery(name = "Order.findAll", query = "select o from Order o")
})
public class Order {
//    orders (order_id, order_date, emp_id, cust_id)

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "order_id", columnDefinition = "BIGINT(20)")
    private long order_id;

    @Column(name = "order_date", columnDefinition = "DATETIME(6)", nullable = false)
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime order_date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "emp_id", nullable = false)
    private Employee emp_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id", nullable = false)
    private Customer cust_id;

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

    public Employee getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Employee emp_id) {
        this.emp_id = emp_id;
    }

    public Customer getCust_id() {
        return cust_id;
    }

    public void setCust_id(Customer cust_id) {
        this.cust_id = cust_id;
    }

    public Order(long order_id, LocalDateTime order_date, Employee emp_id, Customer cust_id) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.emp_id = emp_id;
        this.cust_id = cust_id;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_date=" + order_date +
                ", emp_id=" + emp_id +
                ", cust_id=" + cust_id +
                '}';
    }
}
