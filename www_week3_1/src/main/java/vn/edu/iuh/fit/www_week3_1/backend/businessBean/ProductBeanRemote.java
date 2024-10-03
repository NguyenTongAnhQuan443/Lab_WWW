package vn.edu.iuh.fit.www_week3_1.backend.businessBean;

import vn.edu.iuh.fit.www_week3_1.backend.entities.Product;

import java.util.List;

public interface ProductBeanRemote {
    void add(Product product);
    List<Product> getAll();
    Product getById(int id);
}
