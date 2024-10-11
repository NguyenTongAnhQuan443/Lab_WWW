package vn.edu.iuh.fit.week3.backend.business;

import jakarta.ejb.Local;
import vn.edu.iuh.fit.week3.backend.repositories.entities.Product;

import java.util.List;

@Local
public interface ProductBeanRemote {
    boolean add(Product product);

    List<Product> getAll();

    Product getById(int id);

    boolean deleteById(int id);
}
