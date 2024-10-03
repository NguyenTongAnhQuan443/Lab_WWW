package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
@NamedQueries({
        @NamedQuery(
                name = "OrderDetail.findAllByOrderId",
                query = "SELECT od FROM OrderDetail od WHERE od.order_id = :order_id"
        ),
        @NamedQuery(
                name = "OrderDetail.findByOrderIdAndProductId",
                query = "SELECT od FROM OrderDetail od WHERE od.order_id = :orderId AND od.product_id = :productId"
        ),
        @NamedQuery(name = "OrderDetail.findAll", query = "select o from OrderDetail o")
})
public class OrderDetail {
//    order_detail (order_id, product_id, quantity, price, note)

    @Id
    @ManyToOne(cascade = jakarta.persistence.CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
    private Order order_id;

    @Id
    @ManyToOne(cascade = jakarta.persistence.CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    private Product product_id;

    @Column(name = "quantity", columnDefinition = "DOUBLE", nullable = false)
    private double quantity;

    @Column(name = "price", columnDefinition = "DOUBLE", nullable = false)
    private double price;

    @Column(name = "note", columnDefinition = "VARCHAR(255)")
    private String note;

    public Order getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Order order_id) {
        this.order_id = order_id;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
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

    public OrderDetail(Order order_id, Product product_id, double quantity, double price, String note) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
    }

    public OrderDetail() {
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "order_id=" + order_id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
