package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.enums.ProductStatus;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    //    product (product_id, name, description, unit, manufacturer_name, status)
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "product_id", columnDefinition = "BIGINT(20)")
    private long product_id;

    @Column(name = "name", columnDefinition = "VARCHAR(150)", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "VARCHAR(250)", nullable = false)
    private String description;

    @Column(name = "unit", columnDefinition = "VARCHAR(25)", nullable = false)
    private String unit;

    @Column(name = "manufacturer_name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String manufacturer_name;

    @Column(name = "status", columnDefinition = "INT(11)", nullable = false)
    private ProductStatus status;

    @OneToMany(mappedBy = "product_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "product_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductPrice> productPrices;

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public void setManufacturer_name(String manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<ProductPrice> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(List<ProductPrice> productPrices) {
        this.productPrices = productPrices;
    }

    public Product(long product_id, String name, String description, String unit, String manufacturer_name, ProductStatus status, List<OrderDetail> orderDetails, List<ProductPrice> productPrices) {
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer_name = manufacturer_name;
        this.status = status;
        this.orderDetails = orderDetails;
        this.productPrices = productPrices;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", manufacturer_name='" + manufacturer_name + '\'' +
                ", status=" + status +
                ", orderDetails=" + orderDetails +
                ", productPrices=" + productPrices +
                '}';
    }
}
