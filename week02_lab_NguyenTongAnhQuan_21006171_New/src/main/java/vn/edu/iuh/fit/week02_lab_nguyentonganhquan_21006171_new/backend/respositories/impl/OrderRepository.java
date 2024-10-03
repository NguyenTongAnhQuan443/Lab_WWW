package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.respositories.impl;

import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.connectDB.Connection;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.models.Order;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.respositories.CRUDRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OrderRepository implements CRUDRepository<Order, Long> {
    private EntityManager entityManager;
    private final Logger logger;

    public OrderRepository() {
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
            entityManager.getTransaction().rollback();
            logger.error(e.getMessage());
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
                entityManager.getTransaction().rollback();
                logger.error(e.getMessage());
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
            entityManager.getTransaction().rollback();
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public Optional<Order> findById(Long id) {
        Order order = entityManager.find(Order.class, id);
        return order == null ? Optional.empty() : Optional.of(order);
    }

    @Override
    public List<Order> findAll() {
        List<Order> orderList = entityManager.createNamedQuery("Order.findAll", Order.class).getResultList();
        return orderList;
    }

    //
    public List<Order> getOrderByPageNum(int numPage, int limitNum) {
        return entityManager.createNamedQuery("Order.findAll", Order.class)
                .setFirstResult((numPage - 1) * limitNum)
                .setMaxResults(limitNum)
                .getResultList();
    }

    public Map<LocalDateTime, Integer> getStatisticsOrderByDate() {
        String queryStr = "SELECT o.order_date, count(o.order_id) FROM Order o group by o.order_date";
        Map<LocalDateTime, Integer> map = new HashMap<>();
        List<Object[]> obj = entityManager.createQuery(queryStr).getResultList();
        for (Object[] o : obj) {
            LocalDateTime localDateTime = LocalDateTime.parse(o[0].toString());
            int num = ((Long) o[1]).intValue();
            map.put(localDateTime, num);
        }
        return map;
    }

    public double getStatisticsOrderNumByDateRange(LocalDateTime beginDate, LocalDateTime endDate) {
        String queryStr = "SELECT sum(od.quantity*od.price) from Order o, OrderDetail od where o.order_id = od.product_id.id " +
                " and o.order_date >= :beginDate and o.order_date <= :endDate";
        List obj = entityManager.createQuery(queryStr)
                .setParameter("beginDate", beginDate)
                .setParameter("endDate", endDate)
                .getResultList();
        if (obj == null || obj.isEmpty()) {
            return 0;
        } else {
            Object o = obj.get(0);
            return o == null ? 0 : ((Double) o);
        }
    }

    public double getStatisticsOrderNumByDateRangeAndEmpId(Long empId, LocalDateTime beginDate, LocalDateTime endDate) {

        String queryStr = "SELECT sum(od.quantity*od.price) FROM Order o, OrderDetail od" +
                " where o.order_id = od.product_id.id and o.emp_id.id = :empId" +
                " and o.order_date >= :beginDate and o.order_date <= :endDate";
        List obj = entityManager.createQuery(queryStr)
                .setParameter("empId", empId)
                .setParameter("beginDate", beginDate)
                .setParameter("endDate", endDate)
                .getResultList();
        if (obj == null || obj.isEmpty()) {
            return 0;
        } else {
            Object o = obj.get(0);
            return o == null ? 0 : ((Double) o);
        }
    }
}
