package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.respositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.slf4j.Logger;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.connectDB.Connection;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.models.Customer;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_new.backend.respositories.CRUDRepository;

import java.util.List;
import java.util.Optional;

public class CustomerRepository implements CRUDRepository<Customer, Long> {
    private EntityManager entityManager;
    private final Logger logger;

    public CustomerRepository() {
        entityManager = Connection.getInstance().getEntityManager();
        logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
    }

    @Override
    public boolean add(Customer customer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
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
        Optional<Customer> optionalCustomer = findById(id);
        if (optionalCustomer.isEmpty()) {
            return false;
        } else {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(optionalCustomer.get());
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
    public boolean update(Customer customer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(customer);
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
    public Optional<Customer> findById(Long id) {
        Customer customer = entityManager.find(Customer.class, id);
        return customer == null ? Optional.empty() : Optional.of(customer);
    }

    @Override
    public List<Customer> findAll() {
        return entityManager.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }

    //
    public List<Customer> getCustByPageNum(int numPage, int limitNum) {
        return entityManager.createNamedQuery("Customer.findAll", Customer.class)
                .setFirstResult((numPage - 1) * limitNum)
                .setMaxResults(limitNum)
                .getResultList();
    }
}
