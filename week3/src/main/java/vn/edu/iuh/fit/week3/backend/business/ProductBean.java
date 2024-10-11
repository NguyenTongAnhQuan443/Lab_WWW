package vn.edu.iuh.fit.week3.backend.business;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week3.backend.repositories.entities.Product;

import java.util.List;

@Stateless
public class ProductBean implements ProductBeanRemote {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;
    private final Logger logger;

    public ProductBean() {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public boolean add(Product product) {
        try {
            entityManager.persist(product);
            entityManager.flush();
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Product> getAll() {
        return entityManager.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    @Override
    public Product getById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public boolean deleteById(int id) {
        return entityManager.createNamedQuery("Product.deleteById")
                .setParameter("id", id)
                .executeUpdate() > 0;
    }
}
