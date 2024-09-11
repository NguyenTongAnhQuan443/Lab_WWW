package vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories.impl;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.connectDB.Connection;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.entities.Log;
import vn.edu.iuh.fit.week01_lab_nguyentonganhquan_21006171.respositories.CRUDRespository;

import java.util.List;

public class LogRepositoryImpl implements CRUDRespository<Log, Long> {
    private EntityManager entityManager;

    public LogRepositoryImpl() {
        entityManager = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Log save(Log log) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(log);
            entityManager.getTransaction().commit();
            entityManager.clear();
            return log;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public Log finById(Class<Log> entityClass, Long id) {
        return entityManager.find(Log.class, id);
    }

    @Override
    public List<Log> findAll(Class<Log> entityClass) {
        return entityManager.createNamedQuery("Log.findAll", Log.class).getResultList();
    }

    @Override
    public Boolean update(Log log) {
        try {
            entityManager.getTransaction().begin();;
            entityManager.merge(log);
            entityManager.getTransaction().commit();
            entityManager.clear();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public Boolean deleteById(Class<Log> entityClass, Long aLong) {
        return null;
    }
}
