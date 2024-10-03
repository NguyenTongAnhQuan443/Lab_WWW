package vn.edu.iuh.fit.week3.backend.business;

import vn.edu.iuh.fit.week3.backend.repositories.entity.Product;

import java.util.List;

public interface ProductBeanRemote {
    boolean add(Product product);

    List<Product> getAll();

    Product getById(int id);
}
