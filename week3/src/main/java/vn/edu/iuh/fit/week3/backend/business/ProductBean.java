package vn.edu.iuh.fit.week3.backend.business;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week3.backend.repositories.entity.Product;

import java.util.List;

@Stateless
@LocalBean
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
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
            entityManager.clear();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
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
}
