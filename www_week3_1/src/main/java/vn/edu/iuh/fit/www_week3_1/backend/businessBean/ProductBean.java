package vn.edu.iuh.fit.www_week3_1.backend.businessBean;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.www_week3_1.backend.entities.Product;

import java.util.List;

@Stateless
@LocalBean
public class ProductBean implements ProductBeanRemote {
    private EntityManager entityManager;
    @PersistenceContext(unitName = "default")
    @Override
    public void add(Product product) {
        entityManager.persist(product);
    }

    @Override
    public List<Product> getAll() {
        return entityManager.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    @Override
    public Product getById(int id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }
}
