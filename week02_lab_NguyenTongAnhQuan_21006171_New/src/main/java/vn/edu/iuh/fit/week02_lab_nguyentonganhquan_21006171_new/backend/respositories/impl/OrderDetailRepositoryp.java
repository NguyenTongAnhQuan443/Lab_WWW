package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.respositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.connectDB.Connection;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.models.OrderDetail;

import java.util.List;
import java.util.Optional;

public class OrderDetailRepositoryp {
    private EntityManager entityManager;
    private final Logger logger;

    public OrderDetailRepositoryp() {
        entityManager = Connection.getInstance().getEntityManager();
        logger = LoggerFactory.getLogger(this.getClass());
    }

    public boolean add(OrderDetail orderDetail) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(orderDetail);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error(e.getMessage());
            return false;
        }
    }

    public boolean delete(long orderId, long productId) {
        return false;
    }

    public boolean update(OrderDetail orderDetail) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(orderDetail);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error(e.getMessage());
            return false;
        }
    }

    public Optional<OrderDetail> findByOrderIdAndProductId(long orderId, long productId) {
        Optional<OrderDetail> optionalOrderDetail = entityManager.createNamedQuery("OrderDetail.findByOrderIdAndProductId", OrderDetail.class)
                .setParameter("orderId", orderId)
                .setParameter("productId", productId)
                .getResultList().stream().findFirst();
        return optionalOrderDetail;
    }

    public List<OrderDetail> findOrderDetailsByOrderId(long orderId) {
        return entityManager.createNamedQuery("OrderDetail.findAllByOrderId", OrderDetail.class)
                .setParameter("order_id", orderId)
                .getResultList();
    }

    public List<OrderDetail> findAll() {
        return entityManager.createNamedQuery("OrderDetail.findAll", OrderDetail.class).getResultList();
    }

    public List<OrderDetail> getOrderDetailByNumPage(long orderId, int numPage, int limitNum) {
        return entityManager.createNamedQuery("OrderDetail.findAllByOrderId", OrderDetail.class)
                .setParameter("order_id", orderId)
                .setFirstResult((numPage - 1) * limitNum)
                .setMaxResults(limitNum)
                .getResultList();
    }
}
