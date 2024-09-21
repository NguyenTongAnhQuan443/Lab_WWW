package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.respositories.impl;

import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.connectDB.Connection;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.models.Product_Image;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.respositories.CRUDRespository;

import java.util.List;
import java.util.Optional;

public class ProductImageRespositoryImpl implements CRUDRespository<Product_Image, Long> {
    private EntityManager entityManager;
    private Logger logger;

    public ProductImageRespositoryImpl() {
        entityManager = Connection.getInstance().getEntityManager();
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public boolean add(Product_Image productImage) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(productImage);
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
    public boolean delete(Long id) {
        Optional<Product_Image> optionalProductImage = findById(id);
        if (optionalProductImage.isEmpty()) {
            return false;
        } else {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(optionalProductImage.get());
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
    public boolean update(Product_Image productImage) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(productImage);
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
    public Optional<Product_Image> findById(Long id) {
        Product_Image productImage = entityManager.find(Product_Image.class, id);
        return productImage == null ? Optional.empty() : Optional.of(productImage);
    }

    @Override
    public List<Product_Image> findAll(Class<Product_Image> entity) {
        return entityManager.createNamedQuery("Product_Image.findAll", Product_Image.class).getResultList();
    }
}
