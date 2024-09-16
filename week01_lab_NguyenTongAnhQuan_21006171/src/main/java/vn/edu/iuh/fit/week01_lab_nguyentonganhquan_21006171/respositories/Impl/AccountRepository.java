package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.connectDB.Connection;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.Account;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories.CRUDRespository;

import java.util.List;

public class AccountRepository implements CRUDRespository<Account, String> {
    private final EntityManager entityManager = Connection.getInstance().getEntityManager();

    @Override
    public boolean add(Account account) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(account);
            entityManager.getTransaction().commit();
            entityManager.clear();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            ;
            return false;
        }
    }

    @Override
    public boolean deleteByID(Class<Account> entityClass, String id) {
        return false;
//        try {
//            entityManager.getTransaction().begin();
//            int result = entityManager.createNamedQuery("Account.deleteByAccountId", Account.class)
//                    .setParameter("accountId", s)
//                    .executeUpdate();
//            entityManager.getTransaction().commit();
//            entityManager.clear();
//            return result > 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//            entityManager.getTransaction().rollback();
//            ;
//            return false;
//        }
    }

    @Override
    public boolean update(Account account) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(account);
            entityManager.getTransaction().commit();
            entityManager.clear();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public Account findById(Class<Account> entityClass, String id) {
        return entityManager.find(Account.class, id);
    }

    @Override
    public List<Account> findAll(Class<Account> entityClass) {
//        return entityManager.createNamedQuery("Account.findAll", Account.class).getResultList();
        return null;
    }

//    public Optional<Account> isLogin(String username, String password) {
//        try {
//            Account account = entityManager.createNamedQuery("Account.findByEmailOrPhoneAndPassword", Account.class)
//                    .setParameter("email", username)
//                    .setParameter("phone", username)
//                    .setParameter("password", password)
//                    .getSingleResult();
//            return Optional.of(account);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return Optional.empty();
//    }

    public Account isLogin(String username, String password) {
        Account account;
        try {
            if (!entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().begin();
            }
            account = entityManager.createNamedQuery("Account.findByEmailOrPhoneAndPassword", Account.class)
                    .setParameter("email", username)
                    .setParameter("phone", username)
                    .setParameter("password", password)
                    .getSingleResult();
            entityManager.getTransaction().commit();
            entityManager.clear();
        } catch (NoResultException e) {
            account = null;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            account = null;
        }
        return account;
    }
}
