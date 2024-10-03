package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_price")
public class ProductPrice {
//    product_price (product_id, price_date_time, price, note)

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product_id;

    @Id
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime price_date_time;

    @Column(columnDefinition = "DOUBLE", nullable = false)
    private double price;

    @Column(columnDefinition = "VARCHAR(255)")
    private String note;

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
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

    public ProductPrice(Product product_id, LocalDateTime price_date_time, double price, String note) {
        this.product_id = product_id;
        this.price_date_time = price_date_time;
        this.price = price;
        this.note = note;
    }

    public ProductPrice() {
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "product_id=" + product_id +
                ", price_date_time=" + price_date_time +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
