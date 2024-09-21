package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.respositories.impl;

import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.connectDB.Connection;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.models.Product_Image;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.models.Product_Price;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.respositories.CRUDRespository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ProductPriceRespositoryImpl implements CRUDRespository<Product_Price, LocalDateTime> {
    private EntityManager entityManager;
    private Logger logger;

    public ProductPriceRespositoryImpl(EntityManager entityManager, Logger logger) {
        this.entityManager = Connection.getInstance().getEntityManager();
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public boolean add(Product_Price entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            entityManager.clear();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(LocalDateTime localDateTime) {
        Optional<Product_Price> optionalProductPrice = findById(localDateTime);
        if (optionalProductPrice.isEmpty()) {
            return false;
        } else {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(optionalProductPrice.get());
                entityManager.getTransaction().commit();
                entityManager.clear();
                return true;
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
                logger.error(e.getMessage());
                return false;
            }
        }
    }

    @Override
    public boolean update(Product_Price entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            entityManager.clear();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public Optional<Product_Price> findById(LocalDateTime localDateTime) {
        Product_Price productPrice = entityManager.find(Product_Price.class, localDateTime);
        return productPrice == null ? Optional.empty() : Optional.of(productPrice);
    }

    @Override
    public List<Product_Price> findAll(Class<Product_Price> entity) {
        return entityManager.createNamedQuery("Product_Price.findAll", Product_Price.class).getResultList();
    }
}
