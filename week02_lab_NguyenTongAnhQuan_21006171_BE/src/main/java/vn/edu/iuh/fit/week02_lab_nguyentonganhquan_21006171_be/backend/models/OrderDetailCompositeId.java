package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.models;

import lombok.*;

import java.io.Serializable;
public class OrderDetailCompositeId implements Serializable {
    private long order;
    private long product;

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public long getProduct() {
        return product;
    }

    public void setProduct(long product) {
        this.product = product;
    }
}
