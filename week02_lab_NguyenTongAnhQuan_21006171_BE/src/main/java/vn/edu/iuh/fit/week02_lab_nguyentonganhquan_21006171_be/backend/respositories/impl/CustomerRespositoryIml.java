package vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.respositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.connectDB.Connection;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.models.Customer;
import vn.edu.iuh.fit.week02_lab_nguyentonganhquan_21006171_be.backend.respositories.CRUDRespository;

import java.util.List;
import java.util.Optional;

public class CustomerRespositoryIml implements CRUDRespository<Customer, Long> {
    private EntityManager entityManager;
    private final Logger logger;

    public CustomerRespositoryIml() {
        entityManager = Connection.getInstance().getEntityManager();
        logger = LoggerFactory.getLogger(this.getClass());
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
    public Optional<Customer> findByIdJoinFetch(Long id) {
        Customer customer = entityManager.createNamedQuery("Customer.findCustomerByIdJoinFetch", Customer.class)
                .setParameter("id", id).getSingleResult();
        return customer == null ? Optional.empty() : Optional.of(customer);
    }

    public Optional<Customer> findByEmail(String email) {
        Customer customer = entityManager.createNamedQuery("Customer.findByEmail", Customer.class)
                .setParameter("email", email).getSingleResult();
        return customer == null ? Optional.empty() : Optional.of(customer);
    }

    public List<Customer> getCusByNumPage(int numPage, int limitNum) {
        return entityManager.createNamedQuery("Customer.getPageNum", Customer.class)
                .setFirstResult((numPage - 1) * limitNum)
                .getResultList();
    }

}
