package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.converts.ProductStatusConvert;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.enums.ProductStatus;

import java.util.List;

@Entity
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "select p from Product p"),
        @NamedQuery(name = "Product.findByTopProcNew", query = "select p from Product p order by p.product_id desc")
})
public class Product {
    //    product_id, name, description, unit, manufacturer_name, status
    @Id
    @Column(name = "product_id", columnDefinition = "BIGINT(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column(name = "name", columnDefinition = "VARCHAR(150)")
    private String name;

    @Column(name = "description", columnDefinition = "VARCHAR(250)")
    private String description;

    @Column(name = "unit", columnDefinition = "VARCHAR(25)")
    private String unit;

    @Column(name = "manufacturer_name", columnDefinition = "VARCHAR(100)")
    private String manufacturer_name;

    @Column(name = "status", columnDefinition = "INT(11)")
    @Convert(converter = ProductStatusConvert.class)
    private ProductStatus status;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Order_Detail> orderDetails;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Product_Price> productPrice;

    @OneToMany(mappedBy = "product")
    private List<Product_Image> productImages;

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
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

    public List<Order_Detail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<Order_Detail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<Product_Price> getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(List<Product_Price> productPrice) {
        this.productPrice = productPrice;
    }

    public List<Product_Image> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<Product_Image> productImages) {
        this.productImages = productImages;
    }

    public Product(Long product_id, String name, String description, String unit, String manufacturer_name, ProductStatus status, List<Order_Detail> orderDetails, List<Product_Price> productPrice, List<Product_Image> productImages) {
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer_name = manufacturer_name;
        this.status = status;
        this.orderDetails = orderDetails;
        this.productPrice = productPrice;
        this.productImages = productImages;
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
                ", productPrice=" + productPrice +
                ", productImages=" + productImages +
                '}';
    }
}
