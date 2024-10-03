package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image")
public class ProductImage {
    //    product_image (product_id, image_id, path, alternative)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product_id;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "image_id", columnDefinition = "BIGINT(20)")
    private long image_id;

    @Column(name = "path", columnDefinition = "VARCHAR(250)", nullable = false)
    private String path;

    @Column(name = "alternative", columnDefinition = "VARCHAR(250)")
    private String alternative;

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public long getImage_id() {
        return image_id;
    }

    public void setImage_id(long image_id) {
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

    public ProductImage(Product product_id, long image_id, String path, String alternative) {
        this.product_id = product_id;
        this.image_id = image_id;
        this.path = path;
        this.alternative = alternative;
    }

    public ProductImage() {
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "product_id=" + product_id +
                ", image_id=" + image_id +
                ", path='" + path + '\'' +
                ", alternative='" + alternative + '\'' +
                '}';
    }
}
