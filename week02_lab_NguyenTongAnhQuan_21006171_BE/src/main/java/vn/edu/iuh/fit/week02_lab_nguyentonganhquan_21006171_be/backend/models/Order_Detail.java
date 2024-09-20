package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "order_detail")
@XmlRootElement
public class Order_Detail {
//    order_detail (order_id, product_id, quantity, price, note)

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @Column(name = "quantity", columnDefinition = "DOUBLE")
    private double quantity;

    @Column(name = "price", columnDefinition = "DOUBLE")
    private double price;

    @Column(name = "note", columnDefinition = "VARCHAR(255)")
    private String note;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    public Order_Detail(Order order, Product product, double quantity, double price, String note) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
    }

    public Order_Detail(Order order) {
        this.order = order;
    }

    public Order_Detail() {
    }

    @Override
    public String toString() {
        return "Order_Detail{" +
                "order=" + order +
                ", product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
