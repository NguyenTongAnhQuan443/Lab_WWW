package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories.impl;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.connectDB.Connection;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.Account;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.Role;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories.CRUDRespository;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.sevices.RoleSevice;

import java.lang.reflect.Constructor;
import java.util.List;

public class AccountRepositoryImpl implements CRUDRespository<Account, String> {
    private EntityManager entityManager;

    public AccountRepositoryImpl() {
        Connection.getInstance().getEntityManagerFactory().getCache().evictAll();
        entityManager = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Account save(Account account) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(account);
            entityManager.getTransaction().commit();
            entityManager.clear();
            return account;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public Account finById(Class<Account> entityClass, String id) {
        return entityManager.find(Account.class, id);
    }

    @Override
    public List<Account> findAll(Class<Account> entityClass) {
        return entityManager.createNamedQuery("Account.findAll", Account.class).getResultList();
    }

    @Override
    public Boolean update(Account account) {
        try {
            entityManager.getTransaction().begin();
            ;
            entityManager.merge(account);
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
    public Boolean deleteById(Class<Account> entityClass, String id) {
        try {
            entityManager.getTransaction().begin();
            int result = entityManager.createNamedQuery("Account.deleteByAccountId")
                    .setParameter("accountId", id)
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

    public Account findByAccountIdOrEmail(String userNameOrEmail, String password) {
        try {
            entityManager.getTransaction().begin();
            Account account = (Account) entityManager
                    .createNamedQuery("Account.findByAccountIdOrEmailAndPassword", Account.class)
                    .setParameter("accountId", userNameOrEmail)
                    .setParameter("email", userNameOrEmail)
                    .setParameter("password", password);
            entityManager.getTransaction().commit();
            entityManager.clear();
            return account;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            ;
            return null;
        }
    }

//    public List<Account> findAllAccountNoRole(Class<Account> entityClass){
//        List<Account> accountList = findAll(entityClass);
//        RoleSevice roleSevice = new RoleSevice();
//        List<Role> roleList= roleSevice.findAll();
//        return accountList.stream().filter(e -> e.get)
//    }
}
