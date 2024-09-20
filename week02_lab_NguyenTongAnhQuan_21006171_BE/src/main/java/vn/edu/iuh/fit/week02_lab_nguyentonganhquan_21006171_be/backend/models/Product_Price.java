package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_price")
public class Product_Price {
//    product_price (product_id, price_date_time, price, note)

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @Id
    @Column(name = "price_date_time", columnDefinition = "DATETIME(6)")
    @JsonbDateFormat("yyyy-MM-dd")
    private LocalDateTime price_date_time;

    @Column(name = "price", columnDefinition = "DOUBLE")
    private double price;

    @Column(name = "note", columnDefinition = "VARCHAR(255)")
    private String note;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getPrice_date_time() {
        return price_date_time;
    }

    public void setPrice_date_time(LocalDateTime price_date_time) {
        this.price_date_time = price_date_time;
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

    public Product_Price(Product product, LocalDateTime price_date_time, double price, String note) {
        this.product = product;
        this.price_date_time = price_date_time;
        this.price = price;
        this.note = note;
    }

    public Product_Price(Product product) {
        this.product = product;
    }

    public Product_Price() {
    }

    @Override
    public String toString() {
        return "Product_Price{" +
                "product=" + product +
                ", price_date_time=" + price_date_time +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
