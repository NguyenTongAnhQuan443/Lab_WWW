package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.connection.Connection;
import vn.edu.iuh.fit.models.Log;

import java.util.List;

public class LogRepository implements CRUDRepository<Log, Long> {
    private final EntityManager entityManager = Connection.getInstance().getEntityManager();

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
    public boolean deleteByID(Long id) {
        try {
            entityManager.getTransaction().begin();
            int result = entityManager.createNamedQuery("Log.deleteById")
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
    public boolean update(Log log) {
        try {
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
    public Log findByID(Long id) {
        return entityManager.find(Log.class, id);
    }

    @Override
    public List<Log> findAll() {
        return entityManager.createNamedQuery("Log.findAll", Log.class)
                .getResultList();
    }
}
