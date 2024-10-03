package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.respositories.impl;

import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.connectDB.Connection;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.enums.ProductStatus;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.models.Product;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.respositories.CRUDRespository;

import java.util.List;
import java.util.Optional;

public class ProductRespositoryImpl implements CRUDRespository<Product, Long> {

    private EntityManager entityManager;
    private Logger logger;

    public ProductRespositoryImpl() {
        entityManager = Connection.getInstance().getEntityManager();
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public boolean add(Product product) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
            entityManager.clear();
            return false;
        } catch (Exception e) {
            logger.error(e.getMessage());
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        Optional<Product> optionalProduct = findById(id);
        if ((optionalProduct.isEmpty())) {
            return false;
        } else {
            optionalProduct.get().setStatus(ProductStatus.DISCONTINUED);
            return update(optionalProduct.get());
        }
    }

    @Override
    public boolean update(Product product) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(product);
            entityManager.getTransaction().commit();
            entityManager.clear();
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public Optional<Product> findById(Long id) {
        Product product = entityManager.find(Product.class, id);
        return product == null ? Optional.empty() : Optional.of(product);
    }

    @Override
    public List<Product> findAll() {
        return entityManager.createNamedQuery("Product.findAll", Product.class)
                .getResultList();
    }

//
    public List<Product> findTopNewProc(int amount){
        return entityManager.createNamedQuery("Product.findByTopProcNew", Product.class)
                .setMaxResults(amount)
                .getResultList();
    }
}
