package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.respositories.impl;

import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.connectDB.Connection;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.models.Order;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.respositories.CRUDRespository;

import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements CRUDRespository<Order, Long> {
    private EntityManager entityManager;
    private Logger logger;

    public OrderRepositoryImpl() {
        entityManager = Connection.getInstance().getEntityManager();
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public boolean add(Order order) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(order);
            entityManager.getTransaction().commit();
            entityManager.clear();
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            entityManager.getTransaction().begin();
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
        Optional<Order> optionalOrder = findById(id);
        if (optionalOrder.isEmpty()) {
            return false;
        } else {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(optionalOrder.get());
                entityManager.getTransaction().commit();
                entityManager.clear();
                return true;
            } catch (Exception e) {
                logger.error(e.getMessage());
                entityManager.getTransaction().rollback();
                return false;
            }
        }
    }

    @Override
    public boolean update(Order order) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(order);
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
    public Optional<Order> findById(Long id) {
        Order order = entityManager.find(Order.class, id);
        return order == null ? Optional.empty() : Optional.of(order);
    }

    @Override
    public List<Order> findAll(Class<Order> entity) {
        List<Order> orderList = entityManager.createNamedQuery("Order.findAll", Order.class).getResultList();
        return orderList;
    }

    //
    public Optional<Order> findLastOrderByCusId(Long cusId) {
        try {
            List<Order> orderList = entityManager.createNamedQuery("order.findLastOrderByCustId", Order.class)
                    .setParameter("cust_id", cusId)
                    .setMaxResults(1)
                    .getResultList();
            if (orderList.isEmpty()) {
                return Optional.empty();
            } else {
                return Optional.of(orderList.get(0));
            }
        } catch (Exception e) {
            logger.error(e.getMessage());

            return Optional.empty();
        }
    }
}
