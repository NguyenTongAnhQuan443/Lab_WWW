package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.respositories.impl;

import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.connectDB.Connection;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.models.Order_Detail;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.respositories.CRUDRespository;

import java.util.List;
import java.util.Optional;

public class OrderDetailRepositoryImpl implements CRUDRespository<Order_Detail, String> {
    private EntityManager entityManager;
    private Logger logger;

    public OrderDetailRepositoryImpl() {
        entityManager = Connection.getInstance().getEntityManager();
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public boolean add(Order_Detail orderDetail) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(orderDetail);
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
    public boolean delete(String s) {
        return false;
    }

    @Override
    public boolean update(Order_Detail entity) {
        return false;
    }

    @Override
    public Optional<Order_Detail> findById(String s) {
        return Optional.empty();
    }

    @Override
    public List<Order_Detail> findAll() {
        return List.of();
    }

//    @Override
//    public boolean add(Order_Detail orderDetail) {
////        String sql = "INSERT INTO `order_detail` (`price`, `quantity`, `order_id`, `product_id`, `note`) VALUES (?, ?, ?, ?, ?);";
////        try {
////            entityManager.getTransaction().begin();
////
////            double price =
////                    orderDetail
////                            .getProduct()
////                            .getProductPrice()
////                            .get(orderDetail.getProduct().getProductPrice().size() - 1)
////                            .getPrice();
////            entityManager.createNamedQuery(sql)
////                    .setParameter(1, price)
////                    .setParameter(2, orderDetail.getQuantity())
////                    .setParameter(3, orderDetail.getOrder().getOrder_id())
////                    .setParameter(4, orderDetail.getProduct().getProduct_id())
////                    .setParameter(5, orderDetail.getNote()).executeUpdate();
////            entityManager.getTransaction().commit();
////            entityManager.clear();
////            return true;
////        } catch (Exception e) {
////            entityManager.getTransaction().rollback();
////            logger.error(e.getMessage());
////            return false;
////        }
//        try{
//            entityManager.getTransaction().begin();
//            entityManager.persist(orderDetail);
//            entityManager.getTransaction().commit();
//            entityManager.clear();
//            return  true;
//        }catch (Exception e){
//            entityManager.getTransaction().rollback();
//            logger.error(e.getMessage());
//            return false;
//        }
//    }
//
//    @Override
//    public boolean update(Order_Detail orderDetail) {
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.merge(orderDetail);
//            entityManager.getTransaction().commit();
//            entityManager.clear();
//            return true;
//        } catch (Exception e) {
//            entityManager.getTransaction().rollback();
//            logger.error(e.getMessage());
//            return false;
//        }
//    }
//
//    @Override
//    public Optional<Order_Detail> findById(OrderDetailCompositeId OrderDetailCompositeId) {
//        Order_Detail orderDetail = entityManager.createNamedQuery("Order_Detail.findById", Order_Detail.class)
//                .setParameter("orderID", OrderDetailCompositeId)
//                .setParameter("procId", OrderDetailCompositeId.getProduct()).getSingleResult();
//        return orderDetail == null ? Optional.empty() : Optional.of(orderDetail);
//    }
//
//    @Override
//    public List<Order_Detail> findAll() {
//        return entityManager.createNamedQuery("Order_Detail.findAll", Order_Detail.class).getResultList();
//    }


}
