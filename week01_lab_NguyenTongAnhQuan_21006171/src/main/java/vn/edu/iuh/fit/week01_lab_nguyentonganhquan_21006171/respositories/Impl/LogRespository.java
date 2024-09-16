package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories.Impl;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.connectDB.Connection;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.Log;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories.CRUDRespository;

import java.util.List;

public class LogRespository implements CRUDRespository<Log, Long> {
    private EntityManager entityManager = Connection.getInstance().getEntityManager();

    @Override
    public boolean add(Log log) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(log);
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
    public boolean deleteByID(Class<Log> entityClass, Long id) {
        return false;
    }

    @Override
    public boolean update(Log log) {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(log);
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
    public Log findById(Class<Log> entityClass, Long id) {
        return null;
    }

    @Override
    public List<Log> findAll(Class<Log> entityClass) {
        return List.of();
    }
}
