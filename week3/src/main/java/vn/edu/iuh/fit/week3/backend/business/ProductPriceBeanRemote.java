package vn.edu.iuh.fit.week3.backend.business;

import jakarta.ejb.Local;
import vn.edu.iuh.fit.week3.backend.repositories.entities.ProductPrice;

import java.util.List;

@Local
public interface ProductPriceBeanRemote {
    List<ProductPrice> getByIdProduct(int id);

    boolean deleteById(int id);
}
