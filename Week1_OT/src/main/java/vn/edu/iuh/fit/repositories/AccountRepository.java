package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.connection.Connection;
import vn.edu.iuh.fit.models.Account;

import java.util.List;

public class AccountRepository implements CRUDRepository<Account, String> {

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
            return false;
        }
    }

    @Override
    public boolean deleteByID(String id) {
        try {
            entityManager.getTransaction().begin();
            int result = entityManager.createNamedQuery("Account.deleteByID")
                    .setParameter("id", id)
                    .executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.clear();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
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
    public Account findByID(String id) {
        return entityManager.find(Account.class, id);
    }

    @Override
    public List<Account> findAll() {
        return entityManager.createNamedQuery("Account.findAll", Account.class)
                .getResultList();
    }

    public Account checkLogin(String id, String pass) {
        Account account;
        try {
            entityManager.getTransaction().begin();
            account = entityManager.createNamedQuery("Account.login", Account.class)
                    .setParameter("id", id)
                    .setParameter("password", pass)
                    .getSingleResult();
            entityManager.getTransaction().commit();
            entityManager.clear();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            account = null;
        }
        return account;
    }
}
