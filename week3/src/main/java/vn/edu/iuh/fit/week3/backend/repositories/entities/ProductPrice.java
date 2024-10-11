package vn.edu.iuh.fit.week3.backend.repositories.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;

@Entity
@Table(name = "product_price", schema = "www_week3")
@NamedQueries({
        @NamedQuery(name = "ProductPrice.findByProduct_IdOrderByApplyDateDesc", query = "select p from ProductPrice p where p.product.id = :id order by p.applyDate DESC"),
        @NamedQuery(name = "ProductPrice.deleteByProduct_Id", query = "delete from ProductPrice p where p.product.id = :id")
})
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull
    @ColumnDefault("current_timestamp()")
    @Column(name = "apply_date", nullable = false)
    private Timestamp applyDate;

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

    public Timestamp getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Timestamp applyDate) {
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

    public ProductPrice() {
    }

    public ProductPrice(Integer id) {
        this.id = id;
    }

    public ProductPrice(Integer id, Product product, Timestamp applyDate, Double value, String note) {
        this.id = id;
        this.product = product;
        this.applyDate = applyDate;
        this.value = value;
        this.note = note;
    }
}