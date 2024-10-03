package vn.edu.iuh.fit.week3.backend.repositories.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "product_price", schema = "www_week3")
public class ProductPrice {
    @Id
    @Column(name = "price_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull
    @ColumnDefault("current_timestamp()")
    @Column(name = "apply_date", nullable = false)
    private Instant applyDate;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "value", nullable = false)
    private Double value;

    @Lob
    @Column(name = "note")
    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Instant getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Instant applyDate) {
        this.applyDate = applyDate;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ProductPrice(Integer id, Product product, Instant applyDate, Double value, String note) {
        this.id = id;
        this.product = product;
        this.applyDate = applyDate;
        this.value = value;
        this.note = note;
    }

    public ProductPrice() {
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "id=" + id +
                ", product=" + product +
                ", applyDate=" + applyDate +
                ", value=" + value +
                ", note='" + note + '\'' +
                '}';
    }
}