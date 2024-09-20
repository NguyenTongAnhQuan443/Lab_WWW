package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_image")
public class Product_Image {
//    product_image (product_id, image_id, path, alternative)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Product product;

    @Id
    @Column(name = "image_id", columnDefinition = "BIGINT(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long image_id;

    @Column(name = "path", columnDefinition = "VARCHAR(250)")
    private String path;

    @Column(name = "alternative", columnDefinition = "VARCHAR(250)")
    private String alternative;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getImage_id() {
        return image_id;
    }

    public void setImage_id(Long image_id) {
        this.image_id = image_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public Product_Image(Product product, Long image_id, String path, String alternative) {
        this.product = product;
        this.image_id = image_id;
        this.path = path;
        this.alternative = alternative;
    }

    public Product_Image() {
    }

    @Override
    public String toString() {
        return "Product_Image{" +
                "product=" + product +
                ", image_id=" + image_id +
                ", path='" + path + '\'' +
                ", alternative='" + alternative + '\'' +
                '}';
    }
}