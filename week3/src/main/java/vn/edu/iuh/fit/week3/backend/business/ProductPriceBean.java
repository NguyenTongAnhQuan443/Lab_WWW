package vn.edu.iuh.fit.week3.backend.business;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week3.backend.repositories.entities.ProductPrice;

import java.util.List;

@Stateless
public class ProductPriceBean implements ProductPriceBeanRemote {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;
    private final Logger logger;

    public ProductPriceBean() {
        logger = LoggerFactory.getLogger(this.getClass());
    }


    @Override
    public List<ProductPrice> getByIdProduct(int id) {
        return entityManager.createNamedQuery("ProductPrice.findByProduct_IdOrderByApplyDateDesc", ProductPrice.class)
                .setParameter("id", id)
                .getResultList();
    }
}
